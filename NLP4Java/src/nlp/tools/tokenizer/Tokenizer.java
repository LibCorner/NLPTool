package nlp.tools.tokenizer;
import java.util.List;

public abstract class Tokenizer{
	/**
	*@return 分词结果
	*@param 要分词的文本
	**/
	public abstract List<String> tokenize(String text);
}