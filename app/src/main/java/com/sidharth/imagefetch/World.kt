package com.sidharth.imagefetch

/**
 * Created by sidharthvinod on 24/05/17.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class World {

    @SerializedName("worldpopulation")
    @Expose
    var worldpopulation: List<Worldpopulation>? = null

}