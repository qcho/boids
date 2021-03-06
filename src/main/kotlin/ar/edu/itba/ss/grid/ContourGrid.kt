package ar.edu.itba.ss.grid

import ar.edu.itba.ss.model.Entity
import ar.edu.itba.ss.model.UniverseMetadata
import kotlin.math.max
import kotlin.math.min

class ContourGrid(universeMetadata: UniverseMetadata, entities: List<Entity>)
    : Grid(
    1 + universeCellSideCount + 1,
        universeMetadata.boundaries.xMax / universeCellSideCount,
        universeMetadata.boundaries.yMax / universeCellSideCount,
        universeMetadata.boundaries.zMax / universeCellSideCount,
        entities
    ) {

    override operator fun get(x: Int, y: Int, z: Int): Cell {
        val xCoord = min(max(x+1, 0), cellSideCount - 1)
        val yCoord = min(max(y+1, 0), cellSideCount - 1)
        val zCoord = min(max(z+1, 0), cellSideCount - 1)
        return cells[xCoord][yCoord][zCoord]
    }

    companion object {
        private const val universeCellSideCount = 8
    }

}
