package leetcodes.demo.d;

import java.util.Scanner;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 10:12
 */
public class Case6 {

    public static void main(String[] args) {
        Insurance insurance;
        insurance = new Insurance();
        System.out.println("请输入几个数并用逗号隔开：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split(",");
        int[] c = new int[arr.length];
        insurance.setPricecar(Integer.parseInt(arr[0]));
        System.out.println("车价: " + insurance.pricecar);
        for (int j = 1; j < c.length; j++) {
            c[j] = Integer.parseInt(arr[j]);
            System.out.println("选中: " + c[j]);
        }
        for (int i : c) {
            System.out.println(insurance.expenses(i));
        }
    }

    public static class Insurance {
        //1:定义属性: 数据类型 成员变量名称;
        int baseprice = 342, fixedprice = 952, b = 950, a;
        double cardamins, dutyins, crewins, steroins, brokeins, cardaminsdis, sutyinsdis, strinrisk, pricecar;
        double premium = 0.0;

        public void setPricecar(int pricecar) {
            this.pricecar = pricecar;
        }

        // 2:定义方法：[访问修饰符] 返回值类型 方法名称([数据类型 形参1,数据类型 形参2 ...]){ //方法体 }
        public double expenses(int selcet) {
            switch (selcet) {
                case 1:
                    return this.cardamins = pricecar * 0.009 + this.baseprice;//车损险
                case 2:
                    return this.dutyins = this.fixedprice;//第三者责任险
                case 3:
                    return this.crewins = 10000 * 0.29 * this.a;//车上座位人员险,a为座位数
                case 4:
                    return this.steroins = this.pricecar * 0.0042;//全车盗抢险
                case 5:
                    return this.brokeins = this.pricecar * 0.0012;//玻璃破损险
                case 6:
                    return this.cardaminsdis = this.cardamins * 0.0015;//车损险不计免赔额
                case 7:
                    return this.sutyinsdis = this.crewins * 0.0015;//第三者不计免赔额
                case 8:
                    return this.strinrisk = this.b;//交强险
                default:
                    return this.premium = 0.0;
            }
        }

        @Override
        public String toString() {
            return "Insurance{" +
                    "baseprice=" + baseprice +
                    ", fixedprice=" + fixedprice +
                    ", b=" + b +
                    ", a=" + a +
                    ", cardamins=" + cardamins +
                    ", dutyins=" + dutyins +
                    ", crewins=" + crewins +
                    ", steroins=" + steroins +
                    ", brokeins=" + brokeins +
                    ", cardaminsdis=" + cardaminsdis +
                    ", sutyinsdis=" + sutyinsdis +
                    ", strinrisk=" + strinrisk +
                    ", pricecar=" + pricecar +
                    ", premium=" + premium +
                    '}';
        }

        public Insurance() {

        }
    }
}
