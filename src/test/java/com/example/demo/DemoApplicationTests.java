//package com.example.demo;
//
//import com.alibaba.fastjson.JSON;
//import okhttp3.*;
//import sun.misc.BASE64Decoder;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.*;
//
//public class DemoApplicationTests {
//
//    public static void main(String[] args) throws IOException {
////        String originalFilename = "aaa.jpg";
////        String suffixName = ".png";
////        if(originalFilename.lastIndexOf(".")>0){
////            suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
////        }
////        String fileName = "" + System.currentTimeMillis() + ((int) (Math.random() * 100)) +suffixName;
////        System.out.println(fileName);
////        for (int i = 0; i < 1; i++) {
////            String tel = getTel();
////            System.out.println(tel);
////            Map<String,String> getMap = new HashMap<>();
////            getMap.put("user", tel);
////            System.out.println(sendGet("http://39.101.196.190:8081/app/code/sms", getMap));
////            Map<String, String> heards = new HashMap<>();
//////            heards.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
////            Map<String, String> postMap = new HashMap<>();
////            postMap.put("phone", tel);
////            System.out.println(sendPost("http://39.101.196.190:8081/app/user/register?user=" + tel + "&smsCode=666666", heards, postMap));
//////            String tel= "18635589404";
//////            System.out.println(tel);
//////            send(tel);
//////            Thread.sleep(60000);
////        }
//    }
//
//    public static byte[] safeUrlBase64Decode(final String safeBase64Str) throws IOException {
//        String base64Str = safeBase64Str.replace('-', '+');
//        base64Str = base64Str.replace('_', '/');
//        int mod4 = base64Str.length()%4;
//        if(mod4 > 0){
//            base64Str = base64Str + "====".substring(mod4);
//        }
//        return new BASE64Decoder().decodeBuffer(base64Str);
//    }
//    public static void send(String mobile){
//        String resPath = "a.jpg";
//        String imgPath = "D://b.jpg";
//        GenerateImage(sendGet("http://pet.onepetmall.com/code/image", new HashMap<>())
//                , resPath);
////        removeBackground(resPath, imgPath);
//        String code = executeTess4J(resPath);
//        System.out.println(code);
//        Map<String, String> map = new HashMap<>();
//        map.put("code", code.trim());
//        map.put("mobile", mobile);
//        map.put("deviceId", "868710043334239,868710043446769");
//        map.put("type", "login");
//        Map<String, String> heards = new HashMap<>();
//        String s = sendPost("http://pet.onepetmall.com/code/msg",heards, map);
//        System.out.println(s);
//    }
//
//    /**
//     * 返回手机号码
//     */
//    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
//    private static String getTel() {
//        int index=getNum(0,telFirst.length-1);
//        String first=telFirst[index];
//        String second=String.valueOf(getNum(1,888)+10000).substring(1);
//        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
//        return first+second+third;
//    }
//
//    public static int getNum(int start,int end) {
//        return (int)(Math.random()*(end-start+1)+start);
//    }
//
//
//    public static String executeTess4J(String imgUrl){
//        String ocrResult = "";
//        try{
//            ITesseract instance = new Tesseract();
//            //instance.setLanguage("chi_sim");
//            File imgDir = new File(imgUrl);
//            //long startTime = System.currentTimeMillis();
//            ocrResult = instance.doOCR(imgDir);
//        }catch (TesseractException e){
//            e.printStackTrace();
//        }
//        return ocrResult;
//    }
//
//    public static void removeBackground(String imgUrl, String resUrl) {
//        //定义一个临界阈值
//        int threshold = 300;
//        try {
//            BufferedImage img = ImageIO.read(new File(imgUrl));
//            int width = img.getWidth();
//            int height = img.getHeight();
//            for (int i = 1; i < width; i++) {
//                for (int x = 0; x < width; x++) {
//                    for (int y = 0; y < height; y++) {
//                        Color color = new Color(img.getRGB(x, y));
//                        int num = color.getRed() + color.getGreen() + color.getBlue();
//                        if (num >= threshold) {
//                            img.setRGB(x, y, Color.WHITE.getRGB());
//                        }
//                    }
//                }
//            }
//            for (int i = 1; i < width; i++) {
//                Color color1 = new Color(img.getRGB(i, 1));
//                int num1 = color1.getRed() + color1.getGreen() + color1.getBlue();
//                for (int x = 0; x < width; x++) {
//                    for (int y = 0; y < height; y++) {
//                        Color color = new Color(img.getRGB(x, y));
//                        int num = color.getRed() + color.getGreen() + color.getBlue();
//                        if (num == num1) {
//                            img.setRGB(x, y, Color.BLACK.getRGB());
//                        } else {
//                            img.setRGB(x, y, Color.WHITE.getRGB());
//                        }
//                    }
//                }
//            }
//            File file = new File(resUrl);
//            if (!file.exists()) {
//                File dir = file.getParentFile();
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//                try {
//                    file.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            ImageIO.write(img, "jpg", file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //base64字符串转化成图片
//    public static void GenerateImage(String imgStr, String imageName) {
//        try {
//            byte[] bytes = base64ToImgByteArray(imgStr);
//            //生成jpeg图片
//            String imgFilePath = imageName;//新生成的图片
//            OutputStream out = new FileOutputStream(imgFilePath);
//            out.write(bytes);
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static byte[] base64ToImgByteArray(String base64) throws IOException {
//        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//        //因为参数base64来源不一样，需要将附件数据替换清空掉。如果此入参来自canvas.toDataURL("image/png");
//        base64 = base64.replaceAll("data:image/jpg;base64,", "");
//        //base64解码并转为二进制数组
//        byte[] bytes = decoder.decodeBuffer(base64);
//        for (int i = 0; i < bytes.length; ++i) {
//            if (bytes[i] < 0) {// 调整异常数据
//                bytes[i] += 256;
//            }
//        }
//        return bytes;
//    }
//
//    private static String sendGet(String url, Map<String, String> param) {
//        OkHttpClient okHttpClient = new OkHttpClient();
//        String para = "";
//        for (String key : param.keySet()) {
//            para += (key + "=" + param.get(key) + "&");
//        }
//        if (para.lastIndexOf("&") > 0) {
//            para = para.substring(0, para.length() - 1);
//        }
//        String urlNameString = url + "?" + para;
//        //构建一个请求对象
//        Request request = new Request.Builder().url(urlNameString).build();
//        //发送请求
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public static String sendPost(String url, Map<String, String> header, Map<String,String> jsonMap) {
//        String rtstr = "";
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType contentType = MediaType.parse("application/json; charset=utf-8");
//        if (header != null && header.get("Content-Type") != null) {
//            contentType = MediaType.parse(header.get("Content-Type"));
//        }
//
//        RequestBody body = RequestBody.create(contentType, JSON.toJSONString(jsonMap));
//        Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
//
//        //添加header
//        if (header != null) {
//            Iterator it = header.keySet().iterator();
//            while (it.hasNext()) {
//                String key = (String) it.next();
//                requestBuilder.addHeader(key, header.get(key));
//            }
//        }
//        try {
//            Request request = requestBuilder.build();
//            Response response = client.newCall(request).execute();
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
