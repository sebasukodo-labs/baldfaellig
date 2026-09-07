package com.baldfaellig.app.domain

import java.math.BigDecimal
import java.time.LocalDate

data class Subscription(
    val name: String,
    val amount: BigDecimal,
    val currency: String,
    val interval: BillingInterval,
    val nextPayment: LocalDate,
    val category: Category,
    val notes: String?,
    val id: Long? = null,
)

data class BillingInterval(
    val value: Int,
    val unit: BillingIntervalUnit
)

enum class BillingIntervalUnit {
    DAY,
    MONTH,
    YEAR,
}

enum class Category {
    ENTERTAINMENT,
    INSURANCE,
    STREAMING,
    SOFTWARE,
    NEWS,
    EDUCATION,
    FOOD,
    FINANCE,
    FITNESS,
    OTHER,
}