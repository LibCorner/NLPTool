package nlp.tools.tfidf;
import java.util.Map;
import java.util.HashMap;
import nlp.tools.tokenizer.Tokenizer;
import java.util.List;

public class TF{

	/**
	*@param 未分词的文档
	*@return 文档的词频
	*/
	public Map<String,Double> getTF(String doc){
		return null;
	}

	/**
	*@param 分好词的文档
	*@return 文档的词频
	*/
	public Map<String,Double> getTF(List<String> doc){
		Map<String,Double> tf=new HashMap<String,Double>();
		int word_num=doc.size();
		for(String w:doc){
			if(!tf.containsKey(w)){
				tf.put(w,1.0/word_num);
			}else{
				tf.put(w,tf.get(w)+1.0/word_num);
			}
		}
		return tf;
	}
	/**
	*@param 分好词的文档
	*@return 文档的词频
	*/
	public Map<String,Double> getTF(String[] doc){
		Map<String,Double> tf=new HashMap<String,Double>();
		int word_num=doc.length;
		for(String w:doc){
			if(!tf.containsKey(w)){
				tf.put(w,1.0/word_num);
			}else{
				tf.put(w,tf.get(w)+1.0/word_num);
			}
		}
		return tf;
	}
	
}