package cn.edu.bupt.opensource.test.jdk8.lambda;

/**
 * 按变成语言过滤
 * @author chengtengfei
 * @date 2018/12/23
 */
public class ProjectPredicateLanguageImpl implements ProjectPredicate {

    private String language;

    public ProjectPredicateLanguageImpl(String language) {
        this.language = language;
    }

    @Override
    public boolean test(Project project) {
        return language.equals(project.getLanguage());
    }

}
