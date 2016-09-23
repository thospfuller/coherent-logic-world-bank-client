package com.coherentlogic.wb.client.core.domain;

/**
 * An enumeration of available income level codes.
 *
 * @see http://data.worldbank.org/querybuilder IncomeLevels which has ten and
 *  here we only have nine.
 *
 * @see http://api.worldbank.org/incomelevels
 *
 * @see http://data.worldbank.org/node/246
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public enum IncomeLevelCodes {

//    NOC, No longer valid and will be removed.
    OEC,
    HIC,
//    HPC, No longer valid and will be removed.
    LIC,
    LMC,
    LMY,
    MIC,
    UMC,

    /**
     * Not classified.
     */
    INX;
}
