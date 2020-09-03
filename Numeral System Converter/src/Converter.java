import java.util.Scanner;

public class Converter {
    public Converter(){
        //empty
    }
    public void NumeralSystemConverter(){
        try {
            Scanner sc = new Scanner(System.in);
            int source_radix = sc.nextInt();
            if(source_radix<=0 || source_radix>36){
                throw new Exception();
            }
            String source_number = sc.next();
            int target_radix = sc.nextInt();
            if(target_radix<=0 || target_radix>36){
                throw new Exception();
            }
            if (source_radix < 2) {
                int radix = source_number.length();
                System.out.println(Integer.toString(radix, target_radix));
            } else {
                if (target_radix < 2) {
                    int radix = Integer.parseInt(source_number, source_radix);
                    String result = "1";
                    for (int i = 0; i < radix; i++) {
                        System.out.print(result);
                    }
                    System.out.println();
                } else if (!source_number.contains(".")) {
                    int toDecimal = Integer.parseInt(source_number, source_radix);
                    System.out.println(Integer.toString(toDecimal, target_radix));
                } else {
                    StringBuilder result = new StringBuilder();
                    String[] str = source_number.split("\\."); //important!! only with dot "." don't work!!
                    int radix = Integer.parseInt(str[0], source_radix);
                    result.append(Integer.toString(radix, target_radix));
                    result.append('.');
                    if (source_radix == 10) {
                        double num = (Integer.parseInt(str[1], source_radix))
                                /
                                Math.pow(10, String.valueOf(Integer.parseInt(str[1], source_radix)).length());
                        for (int i = 0; i < 5; i++) {
                            num = (num - (int) (num / 1)) * target_radix;
                            result.append(Integer.toString((int) (num / 1), target_radix));
                        }
                        System.out.println(result);
                    } else {
                        double pos = 0;
                        int power = 1;
                        double convert = 0;
                        while (pos < str[1].length()) {
                            pos++;
                            convert = convert + (Integer.parseInt(str[1].substring(power - 1, power), source_radix)
                                    /
                                    Math.pow(source_radix, power));
                            power++;
                        }
                        for (int i = 0; i < 5; i++) {
                            convert = (convert - (int) (convert / 1)) * target_radix;
                            result.append(Integer.toString((int) (convert / 1), target_radix));
                        }
                        System.out.println(result);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("error!");
        }
    }
}
