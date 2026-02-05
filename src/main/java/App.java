import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        List<WiseSaying> wiseSayings = new ArrayList<>();
        int currentId = 0; // id값 자동 증가를 위해 따로 선언

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {

                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                currentId++; // 등록 시 아이디 증가
                wiseSayings.add(new WiseSaying(currentId, content, author)); // 새로운 객체 생성
                System.out.println("%d번 명언이 등록되었습니다".formatted(currentId));
            }
            else if (cmd.equals("목록")) {

                for (int i = wiseSayings.size()-1; i >= 0; i-- ) {
                    WiseSaying wsList = wiseSayings.get(i);
                    System.out.println("%d / %s / %s".formatted(wsList.id, wsList.author, wsList.content));
                }
            }

        }

    }


}
