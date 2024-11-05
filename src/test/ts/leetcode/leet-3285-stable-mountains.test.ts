
function stableMountains(height: number[], threshold: number): number[] {
    return height
        .map((_,i) => i)
        .filter(i => i > 0 && height[i-1] > threshold)
};


describe('findStableMountains', () => {

    it('should return [3, 4] for height = [1, 2, 3, 4, 5] and threshold = 2', () => {
        const height = [1, 2, 3, 4, 5];
        const threshold = 2;
        const result = stableMountains(height, threshold);
        expect(result).toEqual(expect.arrayContaining([3, 4]));
    });

    it('should return [1, 3] for height = [10, 1, 10, 1, 10] and threshold = 3', () => {
        const height = [10, 1, 10, 1, 10];
        const threshold = 3;
        const result = stableMountains(height, threshold);
        expect(result).toEqual(expect.arrayContaining([1, 3]));
    });

    it('should return [] for height = [10, 1, 10, 1, 10] and threshold = 10', () => {
        const height = [10, 1, 10, 1, 10];
        const threshold = 10;
        const result = stableMountains(height, threshold);
        expect(result).toEqual([]);
    });
});