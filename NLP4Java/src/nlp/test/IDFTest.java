package nlp.test;
import nlp.tools.tfidf.IDF;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

public class IDFTest{
	public static void main(String[] args){
		IDF idf=new IDF();
		String doc1="你好 我是 哈哈 你 是 妮妮 呵呵 哈哈 你好";
		String doc2="我是 的 收集 电脑 谁 是 呵呵 几十年";
		List<List<String>> list=new ArrayList<List<String>>();
		list.add(Arrays.asList(doc1.split(" ")));
		list.add(Arrays.asList(doc2.split(" ")));
		Map<String,Double> map=idf.getIDF(list);
		System.out.println(map);
	}
}