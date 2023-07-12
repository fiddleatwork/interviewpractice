package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Leet005LongestPalindromicSubstring {

    /**
     * length = 5
     * checkLength : startIndex max
     * 5 = 0
     * 4 = 1
     * 3 = 2
     * 2 = 3
     * 1 = 4
     */
    @Test
    fun `3 length answer`() {
        assertThat("babad".longestPalindromicSubstring()).isIn("bab", "aba")
    }

    @Test
    fun `2 length answer`() {
        assertThat("cbbd".longestPalindromicSubstring()).isEqualTo("bb")
    }

    @Test
    fun `single character input`() {
        assertThat("a".longestPalindromicSubstring()).isEqualTo("a")
    }

    @Test
    fun `one letter`() {
        assertThat("ac".longestPalindromicSubstring()).isIn("a", "c")
    }

    @Test
    fun `empty input`() {
        assertThat("".longestPalindromicSubstring()).isEqualTo("")
    }

    @Test
    fun `big one`() {
        assertThat("asdf29sjdfj1jsjaffajsj139sjdjasdf".longestPalindromicSubstring()).isEqualTo("1jsjaffajsj1")
    }

    @Test
    fun `leet test case`() {
        assertThat(
            "borcdubqiupahpwjizjjbkncelfazeqynfbrnzuvbhjnyvrlkdyfyjjxnprfocrmisugizsgvhszooktdwhehojbrdbtgkiwkhpfjfcstwcajiuediebdhukqnroxbgtvottummbypokdljjvnthcbesoyigscekrqswdpalnjnhcnqrarxuufzzmkwizptyvjhpfidgmskuaggtpxqisdlyloznkarxofzeeyvteynluofuhbllyiszszbwnsglqjkignusarxsjvctpgiwnhdufmfpanfwxjwlmhgllzsmdpncbwnsbdtsvrjybynifywkulqnzprcxockbhrhvnwxrkvwumyieazclcviumvormynbryaziijpdinwatwqppamfiqfiojgwkvfzyxadyfjrgmtttvlgkqghgbcfhkigfojjkhskzenlpasyozcsuccdxhulcubsgomvcrbqwakrraesfifecmoztayrdjicypakrrneulfbqqxtrdelggedvloebqaztmfyfkhuonrognejxpesmwgnmnnnamvkxqvzrgzdqtvuhccryeowywmbixktnkqnwzlzfvloyqcageugmjqihyjxhssmhkfzxpzxmgpjgsduogfolnkkqizitbvvgrkczmojxnabruwwzxxqcevdwvtiigwckpxnnxxxdhxpgomncttjutrsvyrqcfwxhexhaguddkiesmfrqfjfdaqbkeqinwicphktffuwcazlmerdhraufbpcznbuipmymipxbsdhuesmcwnkdvilqbnkaglloswcpqzdggnhjdkkumfuzihilrpcvemwllicoqiugobhrwdxtoefynqmccamhdtxujfudbglmiwqklriolqfkknbmindxtljulnxhipsieyohnczddabrxzjmompbtnnxvivmoyfzfrxlufowtqzojfclmatthjtbhotdoheusnpirwicbtyrcuojsdmfcx".longestPalindromicSubstring()
        ).isEqualTo("xnnx")
    }

    @Test
    fun `leet test case 2`() {
        assertThat(
            "busislnescsicxpvvysuqgcudefrfjbwwjcchtgqyajdfwvkypfwshnihjdztgmyuuljxgvhdiwphrweyfkbnjgerkmifbirubhseuhrugwrabnjafnbdfjnufdstjbkuwtnpflffaqmjbhssjlnqftgjiglvvequhapasarlkcvbmkwnkuvwktbgfoaxteprobdwswcdyddyvrehvmxrrjiiidatidlpihkbmmruysmhhsncmfdanafdrfpdtfgkglcqpwrrtvacuicohspkounojuziittugpqjyhhkwfnflozbispehrtrnizowrlzcuollagxwtznjwzcumvedjwokueuqktvvouwnsmpxqvvpuwprezrbobrpnwaccwljchdguubjulyilzvmandjjleitweybqkjttschrjjlebnmponvlktzzcdtuybugggcqffkcffpamauvxfbonjrobgpvlyzveiwemmtdvbjciaytvesnocnjrwodtcokgcuoiicxapmrzpkfphjniuvzjrhbnqndfshoduejyktebgdabidxlkstepuwvtrtgbxaeheylicvhrxddijshcvdadxzsccmainyfpfdhqdanfccqkzlmhsfilvoybqojlvbcixjzqpbngdvesuokbxhkomsiqfyukvspqthlzxdnlwthrgaxhtpjzhrugqbfokrdcyurivmzgtynoqfjbafboselxnfupnpqlryvlcxeksirvufepfwczosrrjpudbwqxwldgjyfjhzlzcojxyqjyxxiqvfhjdwtgoqbyeocffnyxhyyiqspnvrpxmrtcnviukrjvpavervvztoxajriuvxqveqsrttjqepvvahywuzwtmgyrzduxfqspeipimyoxmkadrvrdyefekjxcmsmzmtbugyckcbjsrymszftjyllfmoeoylzeahnrxlxpnlvlvzltwnmldi".longestPalindromicSubstring()
        ).isIn("rbobr", "drvrd")
    }

    @Test
    fun `leet test case bb`() {
        assertThat(
            "bb".longestPalindromicSubstring()
        ).isEqualTo("bb")
    }

    @Test
    fun `leet test case super long`() {
        assertThat(
            "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa".longestPalindromicSubstring()
        ).isEqualTo("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa")
    }


    private fun String.longestPalindromicSubstring(): String {
        if (isEmpty()) {
            return ""
        }
        if(length == 1) {
            return this
        }
        var longest = ""
//        for (checkLength in length downTo 0) {
        for (checkLength in 1..length) {
            for (startIndex in 0..(length - checkLength)) {
                //println("checkLength=$checkLength startIndex=$startIndex")
                substring(startIndex, startIndex + checkLength).let {
                    //println("\tChecking $it")
                    if (it.isPalindrome()) {
                        //println("\t\tFound palindrome $it")
                        longest = it
                    }
                }
            }
        }
        //println(palindromes.keys.joinToString("\n"))
        return longest
    }

    private val palindromes: MutableMap<String, Boolean> = mutableMapOf()
    private fun String.isPalindrome(): Boolean {
        return if (length == 1 || palindromes.containsKey(this) || (first() == last() && palindromes.containsKey(substring(1..length - 2)))) {
            //println("hit $this")
            palindromes[this] = true
            true
        } else {
            (this == this.reversed())
                .also {
                    if (it) {
                        palindromes[this] = true
                    }
                }
        }
    }

    private fun String.isPalindromeSlow() = this == this.reversed()
}
