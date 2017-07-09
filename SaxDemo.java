import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

class FileDemo{
    public FileDemo() throws IOException, DocumentException {
        SAXReader reader = new SAXReader();
        File xmlfile = new File("H:/IdeaProjects/SaxDemo/src/Demo.xml");
        Document fileDocument;//从xml文件获取数据
        fileDocument = reader.read(xmlfile);
        OutputFormat formater = OutputFormat.createPrettyPrint();
        formater.setEncoding("utf-8");
        StringWriter out = new StringWriter();
        XMLWriter writer = new XMLWriter(out,formater);
        writer.write(fileDocument);
        writer.close();
        System.out.println(out.toString());
    }
}

class StrDemo{
    public StrDemo() throws IOException, DocumentException {

        SAXReader reader = new SAXReader();
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><books><book><author>Thomas</author><title>Java从入门到放弃</title><publisher>UCCU</publisher>" +
                "</book><book><author>小白</author><title>MySQL从删库到跑路</title><publisher>GoDie</publisher></book>" +
                "<book><author>PHPer</author><title>BestPHP</title><publisher>PHPchurch</publisher></book></books>";

        Document document = reader.read(new ByteArrayInputStream(xml.getBytes("utf-8")));

        OutputFormat formater = OutputFormat.createPrettyPrint();
        formater.setEncoding("utf-8");

        StringWriter out = new StringWriter();
        XMLWriter writer = new XMLWriter(out,formater);
        writer.write(document);
        writer.close();
        System.out.println(out.toString());
    }
}

public class SaxDemo {
    public static void main(String[] args) throws Exception {
        FileDemo test1 = new FileDemo();
        StrDemo test2 = new StrDemo();
    }
}
