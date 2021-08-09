package cn.tanli.test.vo;/**
 * cn.tanli.test.vo
 *
 * @author Tan.li
 * @date 2021/6/29
 */

/**
 *@ClassName person
 *@Description TODO
 *@Author Tan.li
 *@Date 2021/6/29
 *@Since 1.0
 */
public class Person extends BaseTest {

        private  String reson;
        private  String addr;


        public String getReson() {
            return reson;
        }

        public void setReson(String reson) {
            this.reson = reson;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "reson='" + reson + '\'' +
                    ", addr='" + addr + '\'' +
                    "} " + super.toString();
        }
}
