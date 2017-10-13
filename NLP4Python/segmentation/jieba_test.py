#coding:utf-8
import jieba
from jieba import analyse

'''
结巴分词, 
参考：
    [1] http://blog.csdn.net/qq_27231343/article/details/51898940
    [2] https://github.com/fxsjy/jieba/issues
1. 分词
2. 词性标注
3. 使用词典
4. 关键词提取
5. 并行分词
6. 单词位置信息
7. 解决常见问题
'''

###########################分词#########################################
'''
分词：
1. jieba.cut(sentence, cut_all=False, HMM=True)
参数：
    * sentence: str句子
    * cut_all: 是否采用全模式
    * HMM: 是否使用HMM模型
返回：
    * 可迭代的generator
    * 可以使用for循环来获得分词结果

2. jieba.cut_for_search(sentence,HMM=True)
参数：
    * sentence: 句子
    * HMM: 是否使用HMM
返回：
    * 可迭代的generator
    * 可以使用for循环来获得分词结果
    
特点： 适用于搜索引擎构建倒排索引的分词，粒度较细

3. jieba.lcut
返回：
    分词后的单词list

4. jieba.lcut_for_search
返回：
    分词后的单词list

5. jibba.Tokenizer(dictionary=DEFAULT_DICT)
* 新建自定义分词器，可用于同时使用不同词典

6. jibeba.dt
* 默认的分词器
* 所有全局分词相关函数都是该分词器的映射

'''
sent="我来到北京清华大学"
words=jieba.cut(sent,cut_all=True)
print("全模式："+'/ '.join(words)) #全模式

words=jieba.cut(sent,cut_all=False)
print("精确模式： "+'/ '.join(words)) #精确模式

words=jieba.cut_for_search(sent)
print("搜索引擎模式："+'/ '.join(words)) 


#############################################关键词提取###############################################
'''
1. jieba.analyse.extract_tags(sentence,topK=20,withWeight=False,allowPOS=())
参数：
    * sentence: 句子
    * topK: 为返回几个TF/IDF权重最大的关键词，默认值为20
    * withWeight: 是否返回关键词的权值，默认为False
    * allowPOS: 仅包含指定词性的词， 默认为空，即不筛选
2. jieba.analyse.TFIDF(idf_path=None)
* TFIDF实例
* idf_path: IDF频率文件
3. jieba.analyse.set_stop_words(file_name)
* 设置停用词表
4. jieba.analyse.textrank(sentence, topK=20, withWeight=False, allowPOS=('ns','n','vn','v'))
参数：
    * sentence: 句子
    * topK: 为返回几个TF/IDF权重最大的关键词，默认值为20
    * withWeight: 是否返回关键词的权值，默认为False
    * allowPOS: 仅包含指定词性的词
5. jieba.analyse.TextRank()
* 新建自定义TextRank实例
* TextRank的基本思想
(1)文本分词
(2)以固定窗口大小（默认为5，通过span属性调整），词之间的共现关系，构建图
(3)计算图中节点的PageRank, 注意是无向带权图
'''
s = "差的原因是没看到赠品，卖家如果没有就不要写上做虚假宣传"
tags=analyse.extract_tags(sentence=s)
print("关键词："+",".join(tags))

for x, w in jieba.analyse.extract_tags(s, withWeight=True):
    print('%s %s' % (x, w))
    
tags=analyse.textrank(sentence=s)
print(tags)

###################################词性标注#####################################################
'''
1. jieba.posseg.POSTokenizer(tokenizer=None)
* 新建自定义的分词器
* tokenizer参数可指定内部使用的jieba.Tokenizer分词器, jieba.posseg.dt为默认词性标注器
* 标注句子分词后每个词的词性，采用和ictclas兼容的标记方法
2. jieba.posseg.cut(sentence,HMM=True)
'''
words=jieba.posseg.cut(s)
for w,t in words:
    print(w,t)
    
    
##############################并行分词#######################################################    
'''
原理：将目标文本按行分隔后，把各行文本分配到多个 Python 进程并行分词，然后归并结果，从而获得分词速度的可观提升
基于 python 自带的 multiprocessing 模块，目前暂不支持 Windows

用法：

    jieba.enable_parallel(4) # 开启并行分词模式，参数为并行进程数
    jieba.disable_parallel() # 关闭并行分词模式
'''

###################################位置信息####################################################
'''
1. jieba.tokenize(unicode_sentence,mode='default',HMM=True)
参数：
    * sentence:
    * mode: "default"或"search", search为更细粒度的分词
    * HMM
返回：
    * 可迭代的生成器，每次生成一个(word,start,end)元组
'''

result=jieba.tokenize(s)
for r in result:
    print(r)
    
#################################常见问题###########################################################
'''
1. "也好"应该分成"也 好"
解决办法：强调低词频
jieba.suggest_freq(('也','好'),True)
或直接删除该词：
jieba.del_word("也好")
'''
words=jieba.lcut("也好")
print(words)
jieba.del_word("也好")
jieba.add_word("也")
jieba.add_word("好")
jieba.suggest_freq(("也,","好"),True)
words=jieba.lcut("也好")
print(words)

