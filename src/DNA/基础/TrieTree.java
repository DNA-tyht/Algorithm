package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/24 15:21
 */
public class TrieTree {

    public static class TrieNode {
        public int pass; //有多少字符串经过
        public int end; //有多少字符串结尾
        public TrieNode[] nexts; //HashMap<Char, Node> nexts

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26]; //创建26个字母对应的结点
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word != null) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass++;
                int index;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.nexts[index] == null) {
                        node.nexts[index] = new TrieNode();
                    }
                    node = node.nexts[index]; //node移动到下一个结点
                    node.pass++;
                }
                node.end++;
            }
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null; //将以下所有结点释放
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        //查找word加入过几次
        public int search(String word) {
            if (word != null) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.nexts[i] == null) {
                        return 0;
                    }
                    node = node.nexts[index];
                }
                return node.end;
            }
            return 0;
        }

        //加入的字符串中，有几个以pre为前缀
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

    }
}
