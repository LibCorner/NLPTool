package nlp.test;
import nlp.tools.tfidf.TF;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import nlp.bean.Document;
import java.util.Arrays;

public class TFTest{
	public static void main(String[] args){
		String text="你好 我是 天天 甜甜 的 毛毛 和 你好 啊 哈哈";
		List<String> list=new ArrayList<String>();
		String[] words=text.split(" ");
		Document doc=new Document();
		doc.setWords(Arrays.asList(words));
		Map<String,Double> tf=new TF().getTF(doc);
		System.out.println(tf);
	}
}