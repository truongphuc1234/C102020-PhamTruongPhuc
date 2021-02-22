package model.repository;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.bean.service.ServiceView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private static final String INSERT_SERVICE = "insert into service (service_id, " +
            "service_name, " +
            "service_area, " +
            "service_cost, " +
            "service_max_people, " +
            "rent_type_id, " +
            "service_type_id, " +
            "standard_room, " +
            "description_other_convenience, " +
            "pool_area, " +
            "number_of_floors) values (?,?,?,?,?,?,?,?,?,?,?,?);";

    private static final String DELETE_SERVICE = "{CALL delete_service(id)}";

    private static final String GET_SERVICE_BY_ID = "select * from service where service_id = ?;";

    private static final String GET_SERVICE_LIST = "select * from service " +
            "join service_type on service_type.service_type_id = service.service_type_id " +
            "join rent_type on rent_type.rent_type_id = service.rent_type_id;";

    private static final String UPDATE_SERVICE = "update service set " +
            "service_name = ?, " +
            "service_area = ?, " +
            "service_cost = ?, " +
            "service_max_people = ?, " +
            "rent_type_id = ?, " +
            "service_type_id = ?, " +
            "standard_room = ?, " +
            "description_other_convenience = ?, " +
            "pool_area = ?, " +
            "number_of_floors = ? where service_id = ?";

    private static final String GET_SERVICE_TYPE_LIST = "select * from service_type;";

    private static final String GET_RENT_TYPE_LIST = "select * from rent_type;";

    @Override
    public boolean insertService(Service service) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SERVICE)) {
            statement.setString(1, service.getServiceId());
            statement.setString(2, service.getServiceName());
            statement.setDouble(3, service.getServiceArea());
            statement.setInt(4, service.getServiceMaxPeople());
            statement.setInt(5, service.getRentTypeId());
            statement.setInt(6, service.getServiceTypeId());
            statement.setString(7, service.getStandardRoom());
            statement.setString(8, service.getDescriptionOtherConvenience());
            statement.setDouble(9, service.getPoolArea());
            statement.setInt(10, service.getNumberOfFloor());
            if (statement.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean deleteService(String serviceId) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             CallableStatement statement = connection.prepareCall(DELETE_SERVICE)) {
            statement.setString(1, serviceId);
            statement.executeUpdate();
            if (statement.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public Service getService(String serviceId) {
        Service service = null;
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_SERVICE_BY_ID)) {
            statement.setString(1, serviceId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String serviceName = rs.getString("service_name");
                int serviceArea = rs.getInt("service_area");
                double serviceCost = rs.getDouble("service_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                int serviceTypeId = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String descriptionOtherConvenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloors = rs.getInt("number_of_floors");
                service = new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Service> getListService() {
        List<Service> services = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_SERVICE_LIST)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String serviceId = result.getString("service_id");
                String serviceName = result.getString("service_name");
                int serviceArea = result.getInt("service_area");
                double serviceCost = result.getDouble("service_cost");
                int serviceMaxPeople = result.getInt("service_max_people");
                int rentTypeId = result.getInt("rent_type_id");
                int serviceTypeId = result.getInt("service_type_id");
                String standardRoom = result.getString("standard_room");
                String descriptionOtherConvenience = result.getString("description_other_convenience");
                double poolArea = result.getDouble("pool_area");
                int numberOfFloors = result.getInt("number_of_floors");
                String rentTypeName = result.getString("rent_type_name");
                String serviceTypeName = result.getString("service_type_name");
                Service service = new ServiceView(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, rentTypeName, serviceTypeName);
                services.add(service);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return services;
    }

    @Override
    public List<ServiceType> getListServiceType() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_SERVICE_TYPE_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int service_type_id = resultSet.getInt("service_type_id");
                String service_type_name = resultSet.getString("service_type_name");
                ServiceType serviceType = new ServiceType(service_type_id, service_type_name);
                serviceTypes.add(serviceType);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return serviceTypes;
    }

    @Override
    public List<RentType> getListRentType() {
        List<RentType> rentTypes = new ArrayList<>();
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_RENT_TYPE_LIST)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int rentTypeId = resultSet.getInt("rentTypeId");
                String rentTypeName = resultSet.getString("rentTypeName");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");
                RentType rentType = new RentType(rentTypeId, rentTypeName, rentTypeCost);
                rentTypes.add(rentType);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rentTypes;
    }

    @Override
    public boolean updateService(Service service) {
        boolean isSuccess = false;
        try (Connection connection = Repository.getConnection();
             CallableStatement statement = connection.prepareCall(UPDATE_SERVICE)) {
            statement.setString(1, service.getServiceName());
            statement.setDouble(2, service.getServiceArea());
            statement.setInt(3, service.getServiceMaxPeople());
            statement.setInt(4, service.getRentTypeId());
            statement.setInt(5, service.getServiceTypeId());
            statement.setString(6, service.getStandardRoom());
            statement.setString(7, service.getDescriptionOtherConvenience());
            statement.setDouble(8, service.getPoolArea());
            statement.setInt(9, service.getNumberOfFloor());
            statement.setString(10, service.getServiceId());
            statement.executeUpdate();
            if (statement.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
