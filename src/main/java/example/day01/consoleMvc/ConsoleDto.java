package example.day01.consoleMvc;

import java.time.LocalDate;

// [ p.76 ] 참고
public class ConsoleDto {   // todo

    private int no;         // todo 번호
    private String title;   // todo 내용
    private LocalDate dueDate; // todo 작성일
    private boolean finished;   // todo 실행여부

    // 생성자
    
    public ConsoleDto() {
    }

    public ConsoleDto(int no, String title, LocalDate dueDate, boolean finished) {
        this.no = no;
        this.title = title;
        this.dueDate = dueDate;
        this.finished = finished;
    }

    // getter setter
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "ConsoleDto{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", date=" + dueDate +
                ", finished=" + finished +
                '}'+"\n";
    }
}
