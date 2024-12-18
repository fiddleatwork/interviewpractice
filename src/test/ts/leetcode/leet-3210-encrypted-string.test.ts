
function getEncryptedString(s: string, k: number): string {
    return Array.from(s)
        .map((_, i) => wrappingGetChar(s, i + k))
        .join("")
};

function wrappingGetChar(s: string, n: number): string {
    return s.charAt(n % s.length)
}

describe("encrypted string", () => {
    it("example1", () => {
        expect(getEncryptedString("dart", 3)).toEqual("tdar")
    })
    it("example2", () => {
        expect(getEncryptedString("aaa", 1)).toEqual("aaa")
    })

    it("should get character after wrapping around", () => {
        expect(wrappingGetChar("abc", 0)).toEqual("a")
        expect(wrappingGetChar("abc", 1)).toEqual("b")
        expect(wrappingGetChar("abc", 2)).toEqual("c")
        expect(wrappingGetChar("abc", 3)).toEqual("a")
        expect(wrappingGetChar("abc", 4)).toEqual("b")
        expect(wrappingGetChar("abc", 5)).toEqual("c")
        expect(wrappingGetChar("abc", 6)).toEqual("a")
    })

})