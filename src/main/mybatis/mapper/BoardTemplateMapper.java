package mapper;

import entity.BoardTemplate;
import entity.BoardTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoardTemplateMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    long countByExample(BoardTemplateExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int deleteByExample(BoardTemplateExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int deleteByPrimaryKey(Integer level);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int insert(BoardTemplate record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int insertSelective(BoardTemplate record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    List<BoardTemplate> selectByExample(BoardTemplateExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    BoardTemplate selectByPrimaryKey(Integer level);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") BoardTemplate record, @Param("example") BoardTemplateExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int updateByExample(@Param("record") BoardTemplate record, @Param("example") BoardTemplateExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int updateByPrimaryKeySelective(BoardTemplate record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table t_s_board
     * @mbg.generated  Sun May 19 17:39:03 CST 2019
     */
    int updateByPrimaryKey(BoardTemplate record);
}