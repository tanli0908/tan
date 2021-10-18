package cn.tanli.lambda;


/**
 * @ClassName Lambda
 * @Description TODO
 * @Author Tan.li
 * @Date 2021/8/23
 * @Since 1.0
 */
public class Lambda {

    public static void main(String[] args) {
        TestCode testCode=null;
//        testCode  =new TestCode() {
//         @Override
//         public String nameStr(String a, String b) {
//             return "ttt";
//         }
//     };
//     System.out.println(testCode.nameStr("",""));

        testCode=(a,b)->{
         return "ttt"+a+"====="+b+"==";
     };
        System.out.println(testCode.nameStr("中","过"));
        System.out.println();

        System.out.println("Lambd`a.main");

    }



}

interface  TestCode{
    String nameStr(String a,String b);
}
class TestCodeImp implements TestCode{
    @Override
    public String nameStr(String a, String b) {
        return a+b;
    }
}