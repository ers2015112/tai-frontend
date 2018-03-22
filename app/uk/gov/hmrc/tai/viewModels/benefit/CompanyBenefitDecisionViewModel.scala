/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.tai.viewModels.benefit

import play.api.Play.current
import play.api.data.Form
import play.api.i18n.Messages


class CompanyBenefitDecisionViewModel(val benefitName:String,
                                      val employerName:String,
                                      val decisionForm: Form[Option[String]])

object CompanyBenefitDecisionViewModel{

  def apply(benefitType:String,
            employerName:String,
            decisionForm: Form[Option[String]])(implicit messages: Messages): CompanyBenefitDecisionViewModel = {
    val formattedBenefitName = (raw"(B|b)enefit(s)?".r replaceAllIn(
      messages(s"tai.taxFreeAmount.table.taxComponent.${benefitType}"),"")).trim
    new CompanyBenefitDecisionViewModel(formattedBenefitName,employerName,decisionForm)
  }

}
