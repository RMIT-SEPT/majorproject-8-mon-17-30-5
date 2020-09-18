import React from 'react';
import { shallow } from 'enzyme';
import WorkerForm from './WorkerForm';
import Adapter from 'enzyme-adapter-react-13';

configure({ adapter: new Adapter() });


test('Call onSubmit props for form submission', () => {
    const workerInfo = {
        firstName: "Sara",
        lastName: "Tran",
        username: "sara.tran123",
        password: "0123456789"
    }
  
    const onSubmitSpy = jest.fn();
  
    const wrapper = shallow(
      <WorkerForm workerInfo={workerInfo} onSubmit={onSubmitSpy} />
    );
  
    wrapper.find('form').simulate('submit', { preventDefault: () => {} });
  
    expect(wrapper.state('value')).toBe('');
    expect(onSubmitSpy).toHaveBeenLastCalledWith({
      firstName: workerInfo.firstname,
      lastName: workerInfo.lastname,
      username: workerInfo.username,
      password: workerInfo.password
    });
  });