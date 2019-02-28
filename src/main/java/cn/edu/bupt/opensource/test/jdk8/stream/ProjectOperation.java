package cn.edu.bupt.opensource.test.jdk8.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author chengtengfei
 * @date 2018/12/23
 */
public class ProjectOperation {

    public static void main(String[] args) {
        List<Project> projects = Project.buildData();
        List<String> names = projects.stream()
                .filter(p -> {
                    System.out.println(p.getName());
                    return p.getStars() > 1000;
                })
                .map(p -> {
                    System.out.println(p.getName());
                    return p.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
        names.stream().forEach(System.out::println);
    }

}
