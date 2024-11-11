
function checkChains(
    firstChar: string,
    lastChar: string,
    input: string[],
) {
    if (input.length == 0) {
        return firstChar == lastChar
    }
    for (const word of input.filter(w => w[0] == lastChar)) {
        if (
            checkChains(
                firstChar,
                word[word.length - 1],
                input.filter(w => w != word)
            )
        ) {
            return true
        }
    }
    return false
}

function isChainable(input: string[]): boolean {
    if (input.length == 0) {
        return false
    }
    return checkChains(
        input[0][0],
        input[0][input[0].length - 1],
        input.slice(1),
    )

}

describe("ChainOfStringsTest", () => {

    test("example 1 can chain", () => {
        expect(isChainable(["aab", "bac", "aaa", "cda"])).toBe(true);
    });

    test("example 2 cannot chain", () => {
        expect(isChainable(["aaa", "bbb"])).toBe(false);
    });

    test("multiple possible chains", () => {
        expect(isChainable(["abc", "bca", "cab"])).toBe(true);
    });

    test("dead end", () => {
        expect(isChainable(["abc", "bcd", "cde"])).toBe(false);
    });

    test("overlapping strings", () => {
        expect(isChainable(["ab", "abc"])).toBe(false);
    });

    test("basic chainable example with 3 strings", () => {
        expect(isChainable(["abc", "cde", "eab"])).toBe(false);
    });

    test("chainable with repeated characters", () => {
        expect(isChainable(["aab", "bbc", "cca", "aad"])).toBe(false);
    });

    test("all strings with same first and last character", () => {
        expect(isChainable(["aba", "cac", "ded", "efe"])).toBe(false);
    });

    test("larger set of chainable strings", () => {
        expect(isChainable(["giraffe", "elephant", "tiger", "rabbit", "tapir", "rat", "tig"])).toBe(true);
    });

    test("chainable edge case with two strings", () => {
        expect(isChainable(["ab", "ba"])).toBe(true);
    });

    test("chainable with duplicate strings", () => {
        expect(isChainable(["aba", "aba", "bac", "cab"])).toBe(false);
    });

    test("non-chainable due to single mismatch", () => {
        expect(isChainable(["abc", "cde", "efg"])).toBe(false);
    });

    test("non-chainable due to isolated string", () => {
        expect(isChainable(["abc", "cba", "xyz"])).toBe(false);
    });

    test("one string breaks the circle", () => {
        expect(isChainable(["ab", "bc", "cd", "de", "fa"])).toBe(false);
    });

    test("non-chainable with duplicate strings that can't chain", () => {
        expect(isChainable(["abc", "cba", "bac", "dcb"])).toBe(false);
    });

    test("non-chainable edge case with two strings", () => {
        expect(isChainable(["ab", "cd"])).toBe(false);
    });

    test("self-contained loop but no complete circle", () => {
        expect(isChainable(["ab", "bc", "ca", "de"])).toBe(false);
    });

    test("single string that can form a circle", () => {
        expect(isChainable(["aba"])).toBe(true);
    });

    test("single string that cannot form a circle", () => {
        expect(isChainable(["abc"])).toBe(false);
    });

    test("empty array", () => {
        expect(isChainable([])).toBe(false);
    });

    test("array of single character strings with all the same character", () => {
        expect(isChainable(["a", "a", "a"])).toBe(true);
    });

    test("array of single character strings with mixed characters", () => {
        expect(isChainable(["a", "b", "c"])).toBe(false);
    });

    test("all strings with same start and end characters but no chain", () => {
        expect(isChainable(["ab", "bc", "ca", "da"])).toBe(false);
    });

});