package main.java.BuilderMethod;

import java.util.*;

/**
 * 抽象构建器
 */
interface URLBuilder {

    public final static String SSL_SCHEME = "https://";
    public final static String NO_SSL_SCHEME = "http://";

    public URLBuilder builder();

    public URLBuilder setDomain(String domain);

    public URLBuilder setScheme(boolean isSSl);

    public URLBuilder setPath(String path);

    public URLBuilder setQuery(Map<String, String> query);

    public String build();
}

/**
 * 具体构建器
 */

class MyURLBuilder implements URLBuilder {
    private String scheme;
    private String domain;
    private List<String> path;
    private Map<String, String> query;

    public MyURLBuilder() {
        this.scheme = URLBuilder.SSL_SCHEME;
        this.path = new ArrayList<>();
        this.query = new HashMap<>();
    }

    @Override
    public URLBuilder builder() {
        return new MyURLBuilder();
    }

    @Override
    public URLBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    @Override
    public URLBuilder setScheme(boolean isSSl) {
        this.scheme = isSSl ? URLBuilder.SSL_SCHEME : URLBuilder.NO_SSL_SCHEME;
        return this;
    }

    @Override
    public URLBuilder setPath(String path) {
        this.path.add(path);
        return this;
    }

    @Override
    public URLBuilder setQuery(Map<String, String> query) {
        this.query.putAll(query);
        return this;
    }

    @Override
    public String build() {
        final StringJoiner stringQuery = new StringJoiner("&");
        query.forEach((key, value) -> stringQuery.add(key + "=" + value));
        final StringJoiner stringPath = new StringJoiner("/", scheme, "?" + stringQuery.toString());
        stringPath.add(domain);
        path.forEach(stringPath::add);
        return stringPath.toString();//组装结果产品
    }


}

public class BuilderMethodTest {
    public static void main(String[] args) {
        //构建者模式：将一个复杂对象的构建与它的表示分离，使得相同构建过程可以创建不同的表示。
        /*
        案例拼接url，定义一个通用构建器接口，声明了常用方法
        但是具体实现的构建器可能根据其构建过程的不同，对相同的参数产出的具体结果不同
        以此来实现构建和表示分离
         */
        final MyURLBuilder myURLBuilder = new MyURLBuilder();
        final String build = myURLBuilder.setScheme(true).setDomain("www.baidu.com").setPath("movie").setPath("get").setQuery(Map.of("page", "1", "size", "10")).build();
        System.out.println(build);
    }
}

