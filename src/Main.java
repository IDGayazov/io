import java.io.*;

public class Main{
    public static boolean isVowel(char c){
        if(c == 'o' || c == 'a' || c == 'e' ||
        c == 'i' || c == 'u'){
            return true;
        }
        return false;
    }
    public static void task1(String file) {
        try(FileInputStream fis = new FileInputStream(file)){
            int c;
            StringBuilder sb = new StringBuilder();
            while((c = fis.read()) != -1){
                char s = (char)c;
                boolean b = isVowel(s);
                do{
                    s = (char)c;
                    if(s == ' ') break;
                    if(b){
                        sb.append(s);
                    }
                }while((c = fis.read()) != -1);
                if(b){
                    System.out.println(sb);
                    sb.delete(0, sb.length());
                }
                if(c == -1) break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static void task2(String file) {
        try(FileInputStream fis = new FileInputStream(file)){
            int c;
            boolean b = false;
            StringBuilder sb = new StringBuilder();
            while((c = fis.read()) != -1){
                do{
                    char s = (char)c;
                    if(s == ' ') {
                        int c2 = fis.read();
                        if((char)c2 == sb.charAt(sb.length() - 1)){
                            System.out.println(sb);
                        }
                        s = (char)c2;
                        sb.delete(0, sb.length());
                        sb.append(s);
                        break;
                    };
                    sb.append(s);
                }while((c = fis.read()) != -1);
                if(c == -1) break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    static boolean isDigit(char c){
        if(c == '0' ||
            c == '1' ||
            c == '2' ||
            c == '3' ||
            c == '4' ||
            c == '5' ||
            c == '6' ||
            c == '7' ||
            c == '8' ||
            c == '9'){
            return true;
        }
        return false;
    }
    public static void task3(String file) {
        try(FileInputStream fis = new FileInputStream(file)){
            int c;
            StringBuilder sb = new StringBuilder();
            String maxSequence = "";
            while((c = fis.read()) != -1){
                int max = 0, count = 0;
                do{
                    char s = (char)c;
                    if(s == '\n'){
                        sb.delete(0, sb.length());
                       break;
                    }else if(isDigit(s)){
                        count++;
                        sb.append(s);
                    }else{
                        if(count > max){
                            maxSequence = sb.toString();
                            max = count;
                        }
                        sb.delete(0, sb.length());
                        count = 0;
                    }
                }while((c = fis.read()) != -1);
                System.out.println(maxSequence);
                if(c == -1) break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void task4(String sourceFile, String destFile) {
        try(FileInputStream fis = new FileInputStream(sourceFile);
                BufferedWriter bos = new BufferedWriter(new FileWriter(destFile));){

            int c;
            StringBuilder program = new StringBuilder();
            StringBuilder currentWord = new StringBuilder();
            String prevWord = " ";
            char s = ' ';
            while((c = fis.read()) != -1){
                char sLast = s;
                currentWord.delete(0, currentWord.length());
                do{
                    s = (char)c;
                    if(s == ' ' || s == '\n'){
                        break;
                    }
                    currentWord.append(s);
                }while((c = fis.read()) != -1);
                if(!currentWord.toString().equals("class") && prevWord.equals("public")) {
                    bos.write("private" + sLast);
                }else{
                    if(!prevWord.equals(" "))
                        bos.write(prevWord + sLast);
                }
                prevWord = currentWord.toString();
                if(c == -1) break;
            }
            bos.write(currentWord.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void task5(String sourceFile, String destFile) {
        try(FileInputStream fis = new FileInputStream(sourceFile);
            BufferedWriter bos = new BufferedWriter(new FileWriter(destFile));){

            int c;
            StringBuilder program = new StringBuilder();
            StringBuilder line = new StringBuilder();
            char s = ' ';
            while((c = fis.read()) != -1){
                line.delete(0, line.length());
                do{
                    s = (char)c;
                    if(s == '\n'){
                        break;
                    }
                    line.append(s);
                }while((c = fis.read()) != -1);
                bos.write(line.reverse().toString() + '\n');
                if(c == -1) break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Task1");
        task1("text.txt");
        System.out.println("task2");
        task2("text.txt");
        System.out.println("task3");
        task3("text1.txt");
        task4("/home/ilnaz/Документы/io/src/Testing.java", "res.txt");
        task5("/home/ilnaz/Документы/io/src/Testing.java", "res2.txt");
    }
}
