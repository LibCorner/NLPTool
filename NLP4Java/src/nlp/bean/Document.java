package nlp.bean;
import java.util.*;
import nlp.tools.tfidf.TF;

public class Document{
	private int label;
	private List<String> words;
	private Map<String,Double> tf;
	private Map<String,Double> tfidf;

	public Document(){
	}
	public Document setLabel(int label){
		this.label=label;
		return this;
	}
	public int getLabel(){
		return label;
	}
	public Document setWords(List<String> words){
		this.words=words;
		return this;
	}
	public Document setWords(String[] words){
		this.words=Arrays.asList(words);
		return this;
	}
	public List<String> getWords(){
		return words;
	}
	public String toString(){
		return "{"+label+","+words.toString()+"}";
	}
	public Map<String,Double> getTF(){
		return tf;
	}
	public Document setTF(Map<String,Double> tf){
		this.tf=tf;
		return this;
	}
	public Document setTF(){
		this.tf=TF.getTF(words);
		return this;
	}

}