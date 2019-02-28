package cn.edu.bupt.opensource.test.jdk8.lambda;

/**
 * 按 star 数过滤
 * @author chengtengfei
 * @date 2018/12/23
 */
public class ProjectPredicateStarImpl implements ProjectPredicate {

    private Integer stars;

    public ProjectPredicateStarImpl(Integer stars) {
        this.stars = stars;
    }

    @Override
    public boolean test(Project project) {
        return project.getStars() > stars;
    }

}
