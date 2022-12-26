function checkAddCar()
{
    let flag = true;
    let notification;

    //checking client id field
/*    let input_client_id = document.getElementById("client_id").value;
    if (isNaN(input_client_id) || input_client_id < 1)
    {
        notification = "Enter a number greater than 1";
        flag = false;
    }
    else
    { notification = "The id is valid"; }

    document.getElementById("notification_client_id").innerHTML = notification;*/


    //checking plate number field
    let input_plate_number = document.getElementById("plate_number").value;
    if (input_plate_number === "")
    {
        notification = "Enter a plate number";
        flag = false;
    }
    else
    { notification = "The plate number is valid"; }

    document.getElementById("notification_plate_number").innerHTML = notification;
    return flag;
}


function checkAddClient()
{
    let flag = true;
    let notification;

    //checking first name field
    let input_first_name = document.getElementById("first_name").value;
    if (input_first_name && isNaN(input_first_name))
    { notification = "The first name is valid"; }
    else
    {
        notification = "The first name is not valid"
        flag = false;
    }

    document.getElementById("notification_first_name").innerHTML = notification;


    //checking second name field
    let input_second_name = document.getElementById("second_name").value;
    if (input_second_name && isNaN(input_second_name))
    { notification = "The second name is valid"; }
    else
    {
        notification = "The second name is not valid"
        flag = false;
    }

    document.getElementById("notification_second_name").innerHTML = notification;


    //checking phone number field
    let input_phone_number = document.getElementById("phone_number").value;
    if (input_phone_number)
    {
        if (isNaN(input_phone_number))
        {   notification = "Text cannot be a phone number";
            flag = false;
        }
        else
        { notification = "The phone number is valid"; }
    }
    else
    {
        notification = "Enter a phone number";
        flag = false;
    }

    document.getElementById("notification_phone_number").innerHTML = notification;
    return flag;
}


function checkAddCurrentAppointment()
{
    let flag = true;
    let notification;

    //checking planned appointment id field
    let input_planned_appointment_id = document.getElementById("planned_appointment_id").value;
    if (input_planned_appointment_id < 1 || isNaN(input_planned_appointment_id))
    {
        notification = "Enter the id of a planned appointment";
        flag = false;
    }
    else
    { notification = "The id is valid" }

    document.getElementById("notification_planned_appointment_id").innerHTML = notification;
    return flag;
}


function checkAddPlannedAppointment()
{
    let flag = true;
    let notification;

    //checking car id field
    let input_car_id = document.getElementById("car_id").value;
    if (input_car_id < 1 || isNaN(input_car_id))
    {
        notification = "Enter the id of a car";
        flag = false;
    }
    else
    { notification = "The id is valid"; }

    document.getElementById("notification_car_id").innerHTML = notification;
    return flag;
}


function checkCalculateServicesCost()
{
    let flag = true;
    let notification;

    let input_car_id = document.getElementById("car_id").value;
    if (input_car_id < 1 || isNaN(input_car_id))
    {
        notification = "Enter the id of a car";
        flag = false;
    }
    else
    { notification = "The id is valid"; }

    document.getElementById("notification_car_id").innerHTML = notification;
    return flag;
}


function checkChangeServiceState()
{
    {
        let flag = true;
        let notification;

        let input_current_appointment_id = document.getElementById("current_appointment_id").value;
        if (input_current_appointment_id < 1 || isNaN(input_current_appointment_id))
        {
            notification = "Enter the id of a current appointment";
            flag = false;
        }
        else
        { notification = "The id is valid"; }

        document.getElementById("notification_current_appointment_id").innerHTML = notification;
        return flag;
    }
}