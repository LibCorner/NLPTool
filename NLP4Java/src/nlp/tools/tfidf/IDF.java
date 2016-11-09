package nlp.tools.tfidf;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.lang.Math;
import nlp.bean.Document;

public class IDF{
	/**
	*@param 分好词的文档的列表，文档存放在Document对象中
	*@return 每个词的IDF
	*/
	public static Map<String,Double> getIDF(List<Document> docs){
		int doc_num=docs.size();
		Map<String,Integer> df=getDF(docs);
		Map<String,Double> idf=new HashMap<String,Double>();
		Iterator<Entry<String,Integer>> iter=df.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String,Integer> e=iter.next();
			String w=e.getKey();
			Integer num=e.getValue();
			idf.put(w,Math.log((doc_num+1)*1.0/(num+1)));
		}
		return idf;
	}

	/**
	*@param 分好词的文档列表
	*@return 每个词的文档次数
	*/
	public static Map<String,Integer> getDF(List<Document> docs){
		Map<String,Integer> df=new HashMap<String,Integer>();
		for(Document doc : docs){
			Set<String> words=new HashSet<String>(doc.getWords());
			Iterator<String> iter=words.iterator();
			while(iter.hasNext()){
				String w=iter.next();
				if(!df.containsKey(w)){
					df.put(w,1);
				}else{
					df.put(w,df.get(w)+1);
				}
			}
		}
		return df;
	}
	/**
	*@param 分好词的文档的列表,文档存放在List中
	*@return 每个词的IDF
	*/
	public static Map<String,Double> getWordsIDF(List<List<String>> docs){
		int doc_num=docs.size();
		Map<String,Integer> df=getWordsDF(docs);
		Map<String,Double> idf=new HashMap<String,Double>();
		Iterator<Entry<String,Integer>> iter=df.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String,Integer> e=iter.next();
			String w=e.getKey();
			Integer num=e.getValue();
			idf.put(w,Math.log((doc_num+1)*1.0/(num+1)));
		}
		return idf;
	}

	/**
	*@param 分好词的文档列表
	*@return 每个词的文档次数
	*/
	public static Map<String,Integer> getWordsDF(List<List<String>> docs){
		Map<String,Integer> df=new HashMap<String,Integer>();
		for(List<String> doc : docs){
			Set<String> words=new HashSet<String>(doc);
			Iterator<String> iter=words.iterator();
			while(iter.hasNext()){
				String w=iter.next();
				if(!df.containsKey(w)){
					df.put(w,1);
				}else{
					df.put(w,df.get(w)+1);
				}
			}
		}
		return df;
	}

}