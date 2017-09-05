import sun.awt.image.ImageWatched;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by jiayicheng on 17/8/12.
 */
public class Weave {
    ArrayList<LinkedList<Integer>> allSequences(TreeNode node)
    {
        ArrayList<LinkedList<Integer>> result=new ArrayList<LinkedList<Integer>>();

        if(node==null) {
            result.add(new LinkedList<Integer>());
            return result;
        }
    LinkedList<Integer> prefix=new LinkedList<Integer>();
        prefix.add(node.data);
        ArrayList<LinkedList<Integer>> leftSq=allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSq=allSequences(node.right);

        for(LinkedList<Integer> left:leftSq)
        {
        for(LinkedList<Integer> right:rightSq)
        {
            ArrayList<LinkedList<Integer>> weaved=new ArrayList<LinkedList<Integer>>();
            weavelists(left,right,weaved,prefix);
            result.addAll(weaved);
        }
        }
        return result;
    }

    void weavelists(LinkedList<Integer> first,LinkedList<Integer> second,ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix)
    {
        if(first.size()==0||second.size()==0)
        {
            LinkedList<Integer> result=(LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFist=first.removeFirst();
        prefix.addLast((headFist));
        weavelists(first,second,results,prefix);
        prefix.removeLast();
        first.addFirst(headFist);

        int headSecond=second.removeFirst();
        prefix.addLast(headSecond);
        weavelists(first,second,results,prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
        String string;
        string.in
    }

}
