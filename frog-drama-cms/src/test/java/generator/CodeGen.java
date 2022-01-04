package generator;

import cn.oddworld.base.BaseHandler;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

public class CodeGen {

    public static void main(String[] args) throws Exception{
        ClassPathResource resource = new ClassPathResource("generator\\frog-drama-cms-config.yml");
        InputStream stream = resource.getInputStream();
        BaseHandler baseHandler = new BaseHandler();
        String contextPath = System.getProperty("user.dir");
        contextPath = contextPath.replace("\\", "/");
        contextPath += "/frog-drama-cms";
        List<String> warnings = baseHandler.genCode(stream, contextPath);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
