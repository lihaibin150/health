package com.wd.doctor.MVP.View.MyActivity.unbindactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.bwei.example.mylibrary.Base.BaseActivity;
import com.bwei.example.mylibrary.Tools.SPUtils;
import com.bwei.example.mylibrary.Tools.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.MVP.Contracter.HomeContracter;
import com.wd.doctor.MVP.Http.Utils.FileUtil;
import com.wd.doctor.MVP.Model.Bean.My.DoctorIdCardBean;
import com.wd.doctor.MVP.Model.MD5.RsaCoder;
import com.wd.doctor.MVP.Presenter.HomePresenter;
import com.wd.doctor.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//绑定身份证
public class IDCardActivity extends BaseActivity<HomePresenter> implements HomeContracter.IView {

    @BindView(R.id.id_card_sim_backk)
    SimpleDraweeView idCardSimBackk;
    @BindView(R.id.id_card_sim_positive)
    SimpleDraweeView idCardSimPositive;
    @BindView(R.id.id_card_sim_wrong_side)
    SimpleDraweeView idCardSimWrongSide;
    @BindView(R.id.id_card_sim_one)
    SimpleDraweeView idCardSimOne;
    @BindView(R.id.id_card_sim_two)
    SimpleDraweeView idCardSimTwo;
    @BindView(R.id.id_card_btn_next)
    Button idCardBtnNext;
    @BindView(R.id.id_card_btn_finish)
    Button idCardBtnFinish;
    @BindView(R.id.img_id_card_front)
    ImageView imgIdCardFront;
    @BindView(R.id.img_id_card_back)
    ImageView imgIdCardBack;
    @BindView(R.id.linear_id_card_back)
    LinearLayout linearIdCardBack;
    @BindView(R.id.linear_id_card_front)
    LinearLayout linearIdCardFront;
    private String mId;
    private String mSessionId;
    private static final int REQUEST_CODE_CAMERA = 103;
    private String name;
    private String sex;
    private String nation;
    private String num;
    private String birthday;
    private String address;
    private String issueAuthority;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_idcard;
    }


    @Override
    protected void initData() {
        SPUtils spUtils = new SPUtils(IDCardActivity.this, "LoginId");
        mId = spUtils.getString("Id");
        mSessionId = spUtils.getString("SessionId");
//        mP.getDoctorIdCardPresenter(mId,mSessionId,);
        OCR.getInstance(IDCardActivity.this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                //调用成功,返回AccessToken对象
                initLicense();
                String token = accessToken.getAccessToken();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.show("初始化认证成功");
                    }
                });
            }

            @Override
            public void onError(OCRError ocrError) {
                // 调用失败，返回OCRError子类SDKError对象
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.show("初始化认证失败,请检查 key");
                    }
                });
            }
        }, getApplicationContext(), "6T1A3D7tTRxFrytnaci65okm", "dps9dhx3t5ML0jvm8xwNgRP2G8dNohOP");
    }

    //初始化回调监听
    private void initLicense() {
        CameraNativeHelper.init(IDCardActivity.this, OCR.getInstance(IDCardActivity.this).getLicense(), new CameraNativeHelper.CameraNativeInitCallback() {

            private String msg;

            @Override
            public void onError(int errorCode, Throwable e) {
                switch (errorCode) {
                    case CameraView.NATIVE_SOLOAD_FAIL:
                        msg = "加载so失败，请确保apk中存在ui部分的so";
                        break;
                    case CameraView.NATIVE_AUTH_FAIL:
                        msg = "授权本地质量控制token获取失败";
                        break;
                    case CameraView.NATIVE_INIT_FAIL:
                        msg = "本地质量控制";
                        break;
                    default:
                        msg = String.valueOf(errorCode);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.show("本地质量控制初始化错误，错误原因： ");
                    }
                });
            }
        });
    }

    @Override
    public void onSuccess(Object data) {
        DoctorIdCardBean doctorIdCardBean = (DoctorIdCardBean) data;
        if ("0000".equals(doctorIdCardBean.getStatus())) {
            Intent intent = new Intent(this, UnbindActivity.class);
            startActivity(intent);
        } else {
            ToastUtils.show(doctorIdCardBean.getMessage());
            finish();
        }
    }

    @OnClick({R.id.id_card_sim_backk, R.id.id_card_sim_positive, R.id.id_card_sim_wrong_side, R.id.id_card_btn_next, R.id.id_card_btn_finish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_card_sim_backk://返回
                finish();
                break;
            case R.id.id_card_sim_positive://身份证正面
                Intent intent2 = new Intent(IDCardActivity.this, CameraActivity.class);
                intent2.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent2.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
                startActivityForResult(intent2, REQUEST_CODE_CAMERA);
                break;
            case R.id.id_card_sim_wrong_side://身份证反面
                Intent intent = new Intent(IDCardActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                break;
            case R.id.id_card_btn_next:
                idCardBtnFinish.setVisibility(View.VISIBLE);
                idCardBtnNext.setVisibility(View.GONE);
                idCardSimOne.setVisibility(View.VISIBLE);
                idCardSimTwo.setVisibility(View.VISIBLE);
                break;
            case R.id.id_card_btn_finish:
                try {
                    name = RsaCoder.encryptByPublicKey(name);
                    sex = RsaCoder.encryptByPublicKey(sex);
                    nation = RsaCoder.encryptByPublicKey(nation);
                    birthday = RsaCoder.encryptByPublicKey(birthday);
                    address = RsaCoder.encryptByPublicKey(address);
                    num = RsaCoder.encryptByPublicKey(num);
                    issueAuthority = RsaCoder.encryptByPublicKey(issueAuthority);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("doctorId", mId);
                    jsonObject.put("name", name);
                    jsonObject.put("sex", sex);
                    jsonObject.put("nation", nation);
                    jsonObject.put("birthday", birthday);
                    jsonObject.put("address", address);
                    jsonObject.put("num", num);
                    jsonObject.put("issueAuthority", issueAuthority);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray put = jsonArray.put(jsonObject);
                Map<String, Object> BodyMap = new HashMap<>();
                BodyMap.put("BodyMap", put);
                mP.getDoctorIdCardPresenter(mId, mSessionId, BodyMap);
                break;
            case R.id.id_card_sim_one://小红叉(正面)
                imgIdCardFront.setImageDrawable(null);
                idCardSimOne.setVisibility(View.GONE);
                linearIdCardFront.setVisibility(View.VISIBLE);
                break;
            case R.id.id_card_sim_two://小红叉(反面)
                imgIdCardBack.setImageDrawable(null);
                idCardSimTwo.setVisibility(View.GONE);
                linearIdCardBack.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        imgIdCardFront.setImageBitmap(bitmap);
                        linearIdCardFront.setVisibility(View.GONE);
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        imgIdCardBack.setImageBitmap(bitmap);
                        linearIdCardBack.setVisibility(View.GONE);
                    }
                }
            }
        }
    }

    /**
     * 解析身份证图片
     *
     * @param filePath 图片路径
     * @a0GPi4bzLzuT9dDpU5Zp1Ce7InFDAjUw param idCardSide 身份证正反面
     */
    private void recIDCard(final String idCardSide, String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(40);
        OCR.getInstance(IDCardActivity.this).recognizeIDCard(param, new OnResultListener<IDCardResult>() {


            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {
                    name = "";
                    sex = "";
                    nation = "";
                    num = "";
                    birthday = "";
                    address = "";
                    issueAuthority = "";
                    if (result.getName() != null) {
                        name = result.getName().toString();
                    }
                    if (result.getGender() != null) {
                        sex = result.getGender().toString();
                    }
                    if (result.getEthnic() != null) {
                        nation = result.getEthnic().toString();
                    }
                    if (result.getIdNumber() != null) {
                        num = result.getIdNumber().toString();
                    }
                    if (result.getBirthday() != null) {
                        birthday = result.getBirthday().toString();
                    }
                    if (result.getAddress() != null) {
                        address = result.getAddress().toString();
                    }
                    if (result.getIssueAuthority() != null) {
                        issueAuthority = result.getIssueAuthority().toString();
                    }
                    if (idCardSide.equals("front")) {
                        ToastUtils.show("姓名: " + name + "\n" +
                                "性别: " + sex + "\n" +
                                "民族: " + nation + "\n" +
                                "身份证号码: " + num + "\n" +
                                "生日" + birthday + "\n" +
                                "住址: " + address + "\n");


                    } else if (idCardSide.equals("back")) {
                        ToastUtils.show("签发机关: " + issueAuthority + "\n");

                    }
                }
            }

            @Override
            public void onError(OCRError error) {
                ToastUtils.show("识别出错,请查看log错误代码");

            }
        });
    }

    @Override
    public HomePresenter mPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onImgSuccess(Object data) {

    }

    @Override
    public void onFailure(Throwable e) {

    }

    @Override
    public void onImgFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
