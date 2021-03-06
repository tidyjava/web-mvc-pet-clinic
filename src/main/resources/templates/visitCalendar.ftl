<#-- @ftlvariable name="visitCalendar" type="com.tidyjava.petclinic.application.VisitCalendar" -->
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <style>
        .navigation {
            margin-top: 20px;
            margin-bottom: 20px;
        }

        table {
            table-layout: fixed;
            width: 100%;
        }

        th:first-of-type {
            width: 70px;
        }

        .visit-form {
            opacity: 0;
        }

        .visit-form:hover {
            opacity: 1;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="row navigation">
        <h1 class="col-3">
            <a href="/previous">Previous</a>
        </h1>
        <h1 class="col-6 text-center">
        ${visitCalendar.currentWeek.start} - ${visitCalendar.currentWeek.end}
        </h1>
        <h1 class="col-3 text-right">
            <a href="/next">Next</a>
        </h1>
    </div>
    <div class="row">
        <table class="table table-sm table-striped table-bordered">
            <thead class="thead-inverse">
            <tr>
                <th></th>
            <#list visitCalendar.openDays as day>
                <th class="text-center">${day}</th>
            </#list>
            </tr>
            </thead>
            <tbody>
            <#list visitCalendar.visitTimes as visitTime>
            <tr>
                <td>${visitTime}</td>
                <#list visitCalendar.openDays as day>
                    <td>
                        <#if visitCalendar.visitOn(day, visitTime)??>
                            <#assign visit = visitCalendar.visitOn(day, visitTime)/>
                            <div>${visit.ownerName}</div>
                            <div>${visit.petNames?join(", ")}</div>
                        <#else>
                            <div class="visit-form">
                                <div class="click-to-add text-center">
                                    Click to add
                                </div>
                                <form method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="owner" placeholder="Owner">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="pet" placeholder="Pet">
                                    </div>
                                    <input type="hidden" name="day" value="${day}">
                                    <input type="hidden" name="time" value="${visitTime}">
                                    <input type="submit" class="btn btn-primary" value="Submit">
                                </form>
                            </div>
                        </#if>
                    </td>
                </#list>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
        integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
        integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
        crossorigin="anonymous"></script>

<script>
$("form").hide();

$(document).click(function(event) {
    $( "form" ).hide();
    $( ".click-to-add" ).show();
    if($(event.target).closest(".visit-form").length) {
        var formContainer = $(event.target).closest('.visit-form');
        $( "form", formContainer ).show();
        $( ".click-to-add", formContainer ).hide();
    }
})
</script>

</body>

</html>