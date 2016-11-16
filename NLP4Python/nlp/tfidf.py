# -*- coding: utf-8 -*-
#tf计算词频
import numpy as np
corpus_path="tokenized_text.txt"

def getTF(doc):
    '''统计词频
    param:
        doc: 分好词的文档,词的列表
    return:
        词频字典
    '''
    size=len(doc)
    tf={}
    for w in doc:
        if w.strip()=="":
            continue
        if not w in tf:
            tf[w]=1.0/size
        else:
            tf[w]+=tf[w]+1.0/size
    return tf
def getDF(docs):
    '''统计词的文档频率
    param:
        docs: 所有的文档列表
    return:
        词的文档频率字典
    '''
    df={}
    for doc in docs:
        words=set(doc)
        for w in words:
            if w.strip()=="":
                continue
            if not w in df:
                df[w]=1.0
            else:
                df[w]+=1.0
    return df
    
def getTFIDF(docs):
    '''计算tfidf
    param:
        docs:所有的文档列列表
    return:
        所有文档的tf-idf列表
    '''
    df=getDF(docs)
    size=len(docs)
    tf_idfs=[]
    for doc in docs:
        tf=getTF(doc)
        tf_idf={}
        for k,v in tf.items():
           tf_idf[k]=v*np.log2((1+size)/(1+df.get(k)))
        tf_idfs.append(tf_idf)
    return tf_idfs
if __name__=="__main__":
    f=open(corpus_path)
    docs=[]
    for line in f:
        words=line.strip().split(" ")
        docs.append(words)
    result=getTFIDF(docs)