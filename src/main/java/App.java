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

                for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                    WiseSaying wsList = wiseSayings.get(i); // wiseSayings[i] 와 같은 맥락
                    System.out.println("%d / %s / %s".formatted(wsList.id, wsList.author, wsList.content));
                }

            }
            else if (cmd.startsWith("삭제?id=")) {
                String strId = cmd.split("id=")[1];
                int deleteId = Integer.parseInt(strId);
                boolean delStatus = false;

                for (int i = 0; i < wiseSayings.size(); i++) {
                    if (deleteId == wiseSayings.get(i).getId()) { // get(i)만 쓰면 객체 전체를 가져옴
                        wiseSayings.remove(i);
                        delStatus = true; // 값이 존재할 경우 delStatus를 true로 변경하여 if(!delStatus) 실행 안 함
                        System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
                        break;
                    }
                }
                if (!delStatus) { // 존재하지 않을 경우
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteId));
                }
            }
            else if (cmd.startsWith("수정?id=")) {
                String strId = cmd.split("id=")[1];
                int modifyId = Integer.parseInt(strId);
                boolean modifyStatus = false;

                for (int i = 0; i < wiseSayings.size(); i++) {
                    if (modifyId == wiseSayings.get(i).getId()) { // get(i)만 쓰면 객체 전체를 가져옴
                        System.out.println("명언(기존) : %s".formatted(wiseSayings.get(i).getContent()));
                        System.out.print("명언 : ");
                        String modifyContent = sc.nextLine();

                        System.out.println("작가(기존) : %s".formatted(wiseSayings.get(i).getAuthor()));
                        System.out.print("작가 : ");
                        String modifyAuthor = sc.nextLine();

                        wiseSayings.get(i).setContent(modifyContent);
                        wiseSayings.get(i).setAuthor(modifyAuthor);

                        modifyStatus = true; // 값이 존재할 경우 delStatus를 true로 변경하여 if(!delStatus) 실행 안 함
                        System.out.println("%d번 명언이 수정되었습니다.".formatted(modifyId));
                        break;
                    }
                }
                if (!modifyStatus) { // 존재하지 않을 경우
                    System.out.println("%d번 명언은 수정하지 않습니다.".formatted(modifyId));
                }


            }

        }

    }


}
