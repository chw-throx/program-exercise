package com.datastruct.SuffixTree;

import java.util.ArrayList;

/**
 * Created by fred_chen on 10/27/15.
 */
public class SuffixTreeConstructor
{
    private int position;
    private int reminder;
    private TripleTuple tuple;
    private SuffixTree tree;
    private ArrayList<String> stringArrayList;
    private int currentTextId;


    class TripleTuple
    {
        public SuffixTreeNode activeNode;
        public Character activeEdge;
        public int activeLength;
        public SuffixTreeNode needSuffixLinkNode;
        public void addSuffixLink(SuffixTreeNode node)
        {
            if (tuple.needSuffixLinkNode != null)
            {
                tuple.needSuffixLinkNode.setSuffixLink(node);
            }
            tuple.needSuffixLinkNode = node;
        }
    }

    public SuffixTreeConstructor()
    {

        tree = new SuffixTree(new SuffixTreeNode().setRoot());
        position = 0;
        reminder = 0;
        currentTextId = 0;
        tuple = new TripleTuple();
        tuple.activeNode = tree.getRoot();
        tuple.activeEdge = '\0';
        tuple.activeLength = 0;
        tuple.needSuffixLinkNode = null;
    }

    private void buildUp(String text)
    {
        int current = currentTextId;
        stringArrayList.add(text);
        char[] charArray = text.toCharArray();
        for(position = 0; position < text.length(); ++position)
        {
            Character c = charArray[position];
            ++reminder;
            do
            {
                if (tuple.activeLength == 0)
                {
                    tuple.activeEdge = c;
                }

                if (!tuple.activeNode.containsKeys(c))
                {
                    SuffixTreeNode newNode = tree.insertNewNode(position, -1, currentTextId);
                    tuple.activeNode.addChild(c, newNode.getIndexInArray());
                    tuple.addSuffixLink(tuple.activeNode);
                }
                else
                {
                    SuffixTreeNode nextNode = tree.getNodeByIndex( tuple.activeNode.getNode(c) );
                    int edgeLength = getEdgeLength(nextNode);
                    if (tuple.activeLength >= edgeLength)
                    {
                        tuple.activeNode = nextNode;
                        tuple.activeLength -= edgeLength;
                        tuple.activeEdge = getCurrentLeftPeer(nextNode);
                        continue;
                    }
                    else
                    {
                        if(isCurrentPositionInEdge(nextNode))
                        {
                            ++tuple.activeLength;
                            tuple.addSuffixLink(tuple.activeNode);
                            break;
                        }
                        else
                        {
                            splitNode(nextNode);
                            nextNode.addChild(c, tree.insertNewNode(position, -1, currentTextId).getIndexInArray());
                            tuple.addSuffixLink(nextNode);
                        }
                    }
                }
                --reminder;
                if (tuple.activeNode.isRoot() && tuple.activeLength > 0)
                {
                    --tuple.activeLength;
                    tuple.activeEdge = charArray[position - reminder + 1];
                }
                else
                {
                    if (tuple.activeNode.getSuffixLink() != null)
                    {
                        tuple.activeNode = tuple.activeNode.getSuffixLink();
                    }
                    else
                    {
                        tuple.activeNode = tree.getRoot();
                    }
                }
            } while(reminder > 0);

        }// end for(position = 0; position < text.length(); ++position)

        ++currentTextId;
    }

    private void splitNode(SuffixTreeNode node)
    {
        int old_endIndex = node.getEndIndex();
        int new_endIndex = node.getBeginIndex() + tuple.activeLength;
        node.setEndIndex(new_endIndex);
        node.addChild(stringArrayList.get(node.getTextId()).charAt(new_endIndex), tree.insertNewNode(new_endIndex, old_endIndex, currentTextId).getIndexInArray());
    }

    private boolean isCurrentPositionInEdge(SuffixTreeNode node)
    {
        if (position >= node.getBeginIndex())
        {
            if (node.getEndIndex() == -1)
            {
                return true;
            }
            else
            {
                if (position < node.getEndIndex())
                {
                    return true;
                }
            }
        }

        return false;
    }

    private int getEdgeLength(SuffixTreeNode node)
    {
        return getCurrentEndIndex(node) - node.getBeginIndex();
    }

    private int getCurrentEndIndex(SuffixTreeNode node)
    {
        int end = position + 1;
        int node_end = node.getEndIndex();
        if (node_end != -1)
        {
            if (end > node_end)
            {
                end = node_end;
            }
        }

        return end;
    }

    private Character getCurrentLeftPeer(SuffixTreeNode node)
    {
       return stringArrayList.get(node.getTextId()).charAt(getCurrentEndIndex(node));
    }
}
