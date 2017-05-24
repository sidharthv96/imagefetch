package com.sidharth.imagefetch

/**
 * Created by sidharthvinod on 24/05/17.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Worldpopulation {

    @SerializedName("rank")
    @Expose
    var rank: Int? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("population")
    @Expose
    var population: String? = null
    @SerializedName("flag")
    @Expose
    var flag: String? = null

}