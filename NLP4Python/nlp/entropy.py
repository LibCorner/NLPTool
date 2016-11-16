# -*- coding: utf-8 -*-
#entropy信息熵
import numpy as np

def calShanonEnt(labels):
    '''计算香农熵
    param:
        labels:所有文档的类别列表
    return:
        香农熵
    '''
    labelCount={}
    for label in labels:
        if not label in labelCount:
            labelCount[label]=labels.count(label)
    entropy=0.0
    allNum=len(labels)
    for k,v in labelCount.items():
        prob=v*1.0/allNum
        entropy-=prob*np.log2(prob)
    return entropy
    
def infoGain(dataSet,labels,index):
    '''计算数据的第index个特征的信息增益,特征的取值为0和非0
    param:
        dataSet:数据集矩阵n*m, 每行一条数据，每列是一个特征
        labels:数据对应的标签向量，n*1
        index:特征列的索引
    return:
        第index个特征的信息增益
    '''
    baseEntropy=calShanonEnt(labels)
    label0=[]
    label1=[]
    for d,l in zip(dataSet,labels):
        if d[index]==0:
            label0.append(l)
        else:
            label1.append(l)
    allNum=float(len(labels))
    newEntropy=len(label0)/allNum*calShanonEnt(label0)+len(label1)/allNum*calShanonEnt(label1)
    return baseEntropy-newEntropy
    
if __name__=="__main__":
    labels=[1,0,1,0]
    dataSet=[[1,1,1,0,0,0],
             [0,0,1,0,0,1],
             [1,0,1,1,1,0],
             [1,2,0,1,1,0]]
    rs=infoGain(dataSet,labels,0)
    print rs
    
