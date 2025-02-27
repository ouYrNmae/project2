//Individual to-do items should be represented by a class and should allow
//a title, description, and priority to be tracked with each to-do item.
//Priority should be specified using a numeric value between 0 and 5, where 5
//indicates high priority, and 0 indicates low priority.
public class Tasks {
    private String title;
    private String desc;
    private int prio;

    public Tasks(String title, String desc, int prio) {
        this.title = title;
        this.desc = desc;
        this.prio = prio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", prio=" + prio +
                '}';
    }
}
