package entity;

public class PlayerInfo {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_u_player.SessionId
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    private String sessionid;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_u_player.Board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    private String board;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_u_player.SessionId
     * @return  the value of t_u_player.SessionId
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    public String getSessionid() {
        return sessionid;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_u_player.SessionId
     * @param sessionid  the value for t_u_player.SessionId
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_u_player.Board
     * @return  the value of t_u_player.Board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    public String getBoard() {
        return board;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_u_player.Board
     * @param board  the value for t_u_player.Board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    public void setBoard(String board) {
        this.board = board;
    }
}