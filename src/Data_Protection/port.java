package Data_Protection;

import java.io.FileReader;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class port {
    public static void main(String[] args) throws Exception {
/**==========FILE===READING======by==lines======================================*/
        String path =  "C:\\Users\\DELEHA\\IdeaProjects\\setBox\\src\\Data_Protection\\portlist.txt";
            FileReader file = new FileReader(path);
            Scanner sc = new Scanner(file);

            String[] arrList = new String[50] ; //lines
            int[]  cc = {0,0,0,0,0,0,0,0};

            String sAddress = "";
            String dAddress = "";
            String dPort = "";
            String sPort = "";
            for (int i = 0; sc.hasNextLine(); i++) {
                arrList[i] = sc.nextLine();
            }

            for(int j = 0; j < arrList.length; j++) {
                String[] line = new String[4];
                for(int i = 0; i < line.length; i++) {
                    line = arrList[j].split(":");
                }
                sAddress = line[0];
                sPort = line[1];
                dAddress = line[2];
                dPort = line[3];
                /**===============PORT======RULES=========if==else==============================*/
                System.out.println(sAddress + " " + sPort + " " + dAddress + " " + dPort);
               if (dAddress.equals("10.10.10.0") && parseInt(dPort) > 1023){ //parse for int comparison
                    cc[0]++;     System.out.println("Allow");
                } else if(dAddress.equals("10.10.10.3")){
                    cc[1] ++;    System.out.println("Deny");
                } else if(dAddress.equals("192.168.2.1")){
                    cc[2] ++;    System.out.println("Deny");
                } else if(sAddress.equals("10.10.10.3")){
                   cc[3] ++;     System.out.println("Deny");
                } else if(sAddress.equals("192.168.2.1")) {
                    cc[4] ++;    System.out.println("Deny");
                } else if(sAddress.equals("192.168.2.0")) {
                    cc[5]++;     System.out.println("Allow");
                } else if (sAddress.equals("10.10.10.5") && dAddress.equals("192.168.2.0")){
                    cc[6] ++;    System.out.println("Allow");
                } else {
                   cc[7] ++;     System.out.println("Deny");

                }

            }
        /**===============SOUT======================================*/
            System.out.println("    RULE" + "   ACTION" + "    PACKETS" +
                    "\n    ----"+"   "+"   ----  "  +"    ----    "  +
                    "\n     1 " + "     allowed: "+"   " + cc[0] +
                    "\n     2 " + "     denied: "+ "    "  + cc[1]+
                    "\n     3 " + "     denied: "+ "    " +  cc[2]+
                    "\n     4 " + "     denied: "+ "    " +  cc[3]+
                    "\n     5 " + "     denied: "+ "    "  + cc[4]+
                    "\n     6 " + "     allowed: "+"   "  +cc[5]+
                    "\n     7 " + "     allowed: "+"   " + cc[6]+
                    "\n     8 " + "     denied: "+ "   "  + cc[7]);
            file.close();

        }

    }

