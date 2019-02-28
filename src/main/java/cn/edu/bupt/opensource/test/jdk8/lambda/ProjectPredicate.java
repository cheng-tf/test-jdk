package cn.edu.bupt.opensource.test.jdk8.lambda;

/**
 * 项目过滤接口
 * @author chengtengfei
 * @date 2018/12/23 0023
 */
public interface ProjectPredicate {

    /**
     * 过滤
     */
    boolean test(Project project);

}
