package nlp.test;
import nlp.tools.tfidf.TF;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TFTest{
	public static void main(String[] args){
		String doc="你好 我是 天天 甜甜 的 毛毛 和 你好 啊 哈哈";
		List<String> list=new ArrayList<String>();
		String[] words=doc.split(" ");
		Map<String,Double> tf=new TF().getTF(words);
		System.out.println(tf);
	}
}