type Coordinate = [number, number];

class NeighborSum {

    constructor(private grid: number[][]) {
        console.log(`grid length ${grid.length}`)
    }

    adjacentSum(value: number): number {
        const [x,y] = this.indexOfValue(value)
        return (this.safeGet(x-1, y) ?? 0) + (this.safeGet(x+1,y) ?? 0) + (this.safeGet(x,y-1) ?? 0) + (this.safeGet(x,y+1) ?? 0)
   }

    diagonalSum(value: number): number {
        const [x,y] = this.indexOfValue(value)
        return (this.safeGet(x-1, y-1) ?? 0) + (this.safeGet(x+1,y-1) ?? 0) + (this.safeGet(x-1,y+1) ?? 0) + (this.safeGet(x+1,y+1) ?? 0)
    }

    private safeGet(x: number, y: number): number | undefined {
        if(x >= 0 && x < this.grid.length &&
            y >= 0 && y < this.grid.length) {
                return this.grid[x][y]
            }
        return undefined            
    }

    private indexOfValue(value: number): Coordinate {
        for(var i=0; i<this.grid.length;i++) {
            for(var j=0; j<this.grid.length;j++) {
                if(this.grid[i][j] == value) {
                    const point: Coordinate = [10, 20];
                    return [i,j]
                }
            }
        }
        throw Error(`Value ${value} doesn't exist.`)
    }
}

describe("Neighbor sum service", () => {

    it("example1", () => {
        const neighborSum = new NeighborSum([[0, 1, 2], [3, 4, 5], [6, 7, 8]])
        expect(neighborSum.adjacentSum(1)).toEqual(6)
        expect(neighborSum.adjacentSum(4)).toEqual(16)
        expect(neighborSum.diagonalSum(4)).toEqual(16)
        expect(neighborSum.diagonalSum(8)).toEqual(4)
    })

})
