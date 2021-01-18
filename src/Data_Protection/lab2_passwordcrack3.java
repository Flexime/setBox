package Data_Protection;
//2 var
public class lab2_passwordcrack3 {
    private static long start;
    private static String possPass = "";

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        System.out.println(loop());
    }
    public static String loop() {


        String pwd = "askar+";
        String charset = "askar!@#$%^&*()_+=";
        char c [] = new char[6];

        loop:
        //loop start
        for (int i = 0; i < charset.length(); i++) {
            c[0] = charset.charAt(i);
            for (int j = 0; j < charset.length(); j++) {
                c[1] = charset.charAt(j);
                for (int k = 0; k < charset.length(); k++) {
                    c[2] = charset.charAt(k);
                    for (int m = 0; m < charset.length(); m++) {
                        c[3] = charset.charAt(m);
                        for (int n = 0; n < charset.length(); n++) {
                            c[4] = charset.charAt(n);
                            for (int l = 0; l < charset.length(); l++) {
                                c[5] = charset.charAt(l);
                                possPass = new String(c);
                                if (pwd.equals(possPass)) {
                                    System.err.println("Password: " + possPass);
                                    System.err.println("It took: " + convertmillis(System.currentTimeMillis() - start));
                                    break loop;
                                    // loop end
                                }
                                else {
                                    System.out.println(possPass);
                                }
                            }
                        }
                    }
                }
            }
        }
        return possPass;
    }

        public static String convertmillis(long input) {
            int days = 0, hours = 0, minutes = 0, seconds = 0, millis = 0;

            int day = 86400000;
            int hour = 3600000;
            int minute = 60000;
            int second = 1000;


            if(input >= day) {
                days = (int) (input / day);
                millis = (int) (input % day);
            } else
                millis = (int) input;

            if(millis >= hour) {
                hours = millis / hour;
                millis = millis% hour;
            }

            if(millis >= minute) {
                minutes = millis / minute;
                millis = millis % minute;
            }

            if(millis >= second) {
                seconds = millis / second;
                millis = millis % second;
            }

            return (days  + " day(s), " + hours + "h, " + minutes + "min, " + seconds + "s and " + millis + "ms");
        }

    }


