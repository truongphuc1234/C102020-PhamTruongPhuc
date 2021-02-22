package model.bean;

public class ResultValidation {
    private boolean pass;
    private String comment;

    public ResultValidation(boolean pass, String comment) {
        this.pass = pass;
        this.comment = comment;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
