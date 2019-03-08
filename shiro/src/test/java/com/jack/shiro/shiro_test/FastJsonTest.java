package com.jack.shiro.shiro_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jack.shiro.PushUser;
import com.jack.shiro.ShiroApplicationTests;
import com.jack.shiro.entity.UpdateUser;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author : peng
 * @Description : FastJson
 * @Date : 2019-02-25 10:29
 */
public class FastJsonTest extends ShiroApplicationTests {

       public static class Student{
        String studentName;
        String studentAge;

        public Student(String studentName,String studentAge) {
            this.studentName = studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public void setStudentAge(String studentAge) {
            this.studentAge = studentAge;
        }

        @Override
        public String toString() {
            return "Test_Student{" +
                    "studentName='" + studentName + '\'' +
                    ", studentAge='" + studentAge + '\'' +
                    '}';
        }
    }


    /**
     *我的测试：
     */
    /*public static void main(String[] args){
        String jsonObject =  "{\"studentName\":\"lily\",\"studentAge\":12}";
        processPost(jsonObject);
        test1();
        test2();
        System.out.println("----------------test 3------------");
        test3();

    }

*/
    //JSON 和 JSONObject之间的区别
    public static String processPost(String jsonObject) {

        JSONObject jsonObject1 = JSON.parseObject(jsonObject);
        JSONObject jsonObject2 = JSONObject.parseObject(jsonObject);
        System.out.println("JSON_1 : "+jsonObject1.getString("studentName")+jsonObject1.getString("studentAge"));
        System.out.println("JSON_2 : "+jsonObject2.getString("studentName")+jsonObject2.getString("studentAge"));
        System.out.println("=====Json转化为JavaBean对象============");

        Student student = JSONObject.parseObject(jsonObject, Student.class);
        //JSONObject.toJSONString();
        System.out.println("转成JavaBean对象："+student);
        return null;
    }
    
    //JSONObject对象 转化为json字符串

    public static void test1(){
        String jsonObject =  "{\"studentName\":\"lily\",\"studentAge\":12}";
        System.out.println(JSONObject.toJSONString(jsonObject));

    }
    //json字符串数组类型 -> 转换为 JsonArray

    public static void test2(){
        String jsonArray = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
        JSONArray jsonArray1 = JSONArray.parseArray(jsonArray);
        int size = jsonArray1.size();
        for (int i = 0 ;i < size ; i++){
            JSONObject jsonObject = jsonArray1.getJSONObject(i);
            System.out.println(jsonObject.getString("studentName")+"  "+jsonObject.getString("studentAge"));
        }
        for (Object object : jsonArray1){
           JSONObject jsonObject =  (JSONObject)object;
            System.out.println("================================");
            System.out.println(jsonObject.getString("studentName")+"  "+jsonObject.getString("studentAge"));

        }

    }
    public static void test3() {

        String complexStr = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
        JSONObject jsonObject = JSONObject.parseObject(complexStr);
        JSONObject course = jsonObject.getJSONObject("course");
        System.out.println("课程名称 ："+course.getString("courseName"));
        JSONArray students = jsonObject.getJSONArray("students");
        for (Object object : students){
            JSONObject object1 = (JSONObject) object;
            System.out.println( "学生姓名："+object1.getString("studentName"));

        }


    }


    public static void test5(String[] args){
        long count = 0;
        PushUser pushUser = new PushUser();
        pushUser.setUserId(1111L);
        pushUser.setAppType(1);
        pushUser.setSex(0);
        pushUser.setCount(null);
        System.out.println("========="+pushUser.getCount());
        //count = pushUser.getCount();
        System.out.println("====Random===============");


        //int r = random.nextInt(2);
      /*  for (int i = 0 ;i<50;i++){
            Random random=new Random();
            int r = random.nextInt(100);
            System.out.println(r);
        }*/

        for (int i = 0 ;i<50;i++){
            int min=-10;
            int max=-1;
            Random random = new Random();

            int randomNum = random.nextInt((max - min) + 1) + min;
            System.out.println("哈哈哈+"+randomNum);
        }
        System.out.println("+===============================");

        Integer min = Integer.valueOf(null);
        System.out.println("min:"+min);


    }


    //switch()不同的case之间的变量之间可以交叉使用
    @Test
    public void test(int param){

        switch (param){
            case 1:
                int max=-10;
                int min=-1;
                Random random = new Random();
                int randomNum = random.nextInt((max - min) + 1) + min;
                //break;
            case 2 :
               /* random.nextInt(3);
            */

        }
    }
    //demo

   public static void test8(String[] args){
        /**
        *转为大写
        */
        String str = "fkladfasdf dsfasdfd   f反反复复";
        String upperCase = str.toUpperCase();
        System.out.println(upperCase);

        JSONObject.toJSONString(str);
       /* JSONObject.parseObject();
        JSONObject.toJavaObject("","")*/
       System.out.println("==JSON中的 @JSONField 的使用=======================");
       UpdateUser user = new UpdateUser(11,"Jack");
       String string = JSONObject.toJSONString(user);
       System.out.println("Serializable"+string);
       System.out.println("------------------------------");
       String str1 = "哈哈哈哈";
       int length = str1.length();
       System.out.println(length);


   }
public static void main(String[] args){
    int verify = verify("哈哈哈哈哈哈哈,哈");
    System.out.println(verify);

}
    private static int verify(String params){
        //一个标签时小于6个字符，两个标签小于8
        String tagName = params;
        if(tagName.length() > 10){
            return 1;
        }
        String[] tags = tagName.split(",");
        List<String> temp = new ArrayList<>();
        for (String tag : tags){
            if(StringUtils.isNotBlank(tag)){
                temp.add(tag);
            }
        }
        if(temp.size() == 2){
            for (String str:temp){
                if (str.length() > 4){
                    return 1;
                }
            }
        }else {
            if(temp.size() != 1 || temp.get(0).length() > 6){
               return 1;
            }
        }
        return 2;
    }

    //
    @Test
    public void test(){
        //test #5
    }
    //test #6

}
