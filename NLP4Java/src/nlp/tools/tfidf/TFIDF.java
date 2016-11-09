package nlp.tools.tfidf;

import nlp.tools.tfidf.TF;
import nlp.tools.tfidf.IDF;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Iterator;
import nlp.bean.Document;

public class TFIDF{
	/**
	*计算tf-idf
	*@param docs:分好词的文档
	*@return 每篇文档中词的tf-idf
	*/
	public List<Map<String,Double>> getWordsTFIDF(List<List<String>> docs){
		List<Map<String,Double>> tfidf=new ArrayList<Map<String,Double>>();
		Map<String,Double> idf=IDF.getWordsIDF(docs);
		for(List<String> doc:docs){
			Map<String,Double> tf=TF.getTF(doc);
			Iterator<Entry<String,Double>> iter=tf.entrySet().iterator();
			while(iter.hasNext()){
				Entry<String,Double> e=iter.next();
				tf.put(e.getKey(),e.getValue()*idf.get(e.getKey()));
			}
			tfidf.add(tf);
		}
		return tfidf;
	}
	/**
	*计算tf-idf
	*@param docs:分好词的文档
	*@return 每篇文档中词的tf-idf
	*/
	public List<Map<String,Double>> getTFIDF(List<Document> docs){
		List<Map<String,Double>> tfidf=new ArrayList<Map<String,Double>>();
		Map<String,Double> idf=IDF.getIDF(docs);
		for(Document doc:docs){
			Map<String,Double> tf=TF.getTF(doc);
			Iterator<Entry<String,Double>> iter=tf.entrySet().iterator();
			while(iter.hasNext()){
				Entry<String,Double> e=iter.next();
				tf.put(e.getKey(),e.getValue()*idf.get(e.getKey()));
			}
			tfidf.add(tf);
		}
		return tfidf;
	}
}